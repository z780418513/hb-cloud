package com.hb.payment.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.google.common.base.Preconditions;
import com.hb.payment.bo.AbstractOrderRequest;
import com.hb.payment.bo.AliPayOrderRequest;
import com.hb.payment.bo.AliPayTradeQuery;
import com.hb.payment.bo.BaseTradeQuery;
import com.hb.payment.enums.PaymentTypeEnum;
import com.hb.payment.mapper.PaymentOrderMapper;
import com.hb.payment.model.PaymentOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhaochengshui
 * @description
 * @date 2022/12/11
 */
@Service("aliPayService")
@Slf4j
public class AliPayService extends AbstractPayService {
    @Resource
    private AlipayClient alipayClient;
    @Resource
    private PaymentOrderMapper paymentOrderMapper;

    @Override
    public String getQrCode(AbstractOrderRequest order) {
        log.info("aliPayService get qrCode , order : {}", order);
        Preconditions.checkArgument(Objects.nonNull(order), "order 不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(order.getAccountId()), "AccountId 不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(order.getChannelOrderId()), "ChannelOrderId 不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(order.getUuid()), "uuid 不能为空");
        AliPayOrderRequest aliPayOrderRequest = (AliPayOrderRequest) order;
        String qrCodeUrl = "";

        // 是否第一次扫码，防止重复扫码
        if (!isFirst(aliPayOrderRequest.getUuid())) {
            log.debug("get qrCode fail, can not repeatability do it");
            return qrCodeUrl;
        }

        // 创建预订单
        if (createPaymentOrder(aliPayOrderRequest) > 0) {
            // 创建alipay预订单
            AlipayTradePrecreateResponse response = doPreCreateAilPayOrder(aliPayOrderRequest);
            if (response.isSuccess()) {
                qrCodeUrl = response.getQrCode();
            }
        }
        log.info("aliPayService get qrCode , qrCodeUrl : {}", qrCodeUrl);
        return qrCodeUrl;
    }

    @Override
    public String tradeQuery(BaseTradeQuery tradeQuery) {
        Preconditions.checkArgument(Objects.nonNull(tradeQuery), "tradeQuery 不能为空");
        AliPayTradeQuery aliPayTradeQuery = (AliPayTradeQuery) tradeQuery;
        Preconditions.checkArgument(StringUtils.isNotBlank(aliPayTradeQuery.getOutTradeNo()) ||
                StringUtils.isNotBlank(aliPayTradeQuery.getTradeNo()), "out_trade_no trade_no 不能都为空");

        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", aliPayTradeQuery.getOutTradeNo());
        bizContent.put("trade_no", aliPayTradeQuery.getTradeNo());
        request.setBizContent(bizContent.toString());

        try {
            AlipayTradeQueryResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                return response.getBody();
            }
        } catch (AlipayApiException e) {
            log.error("AliPayService tradeQuery error ", e);
        }
        return null;
    }


    /**
     * 创建支付宝预订单
     *
     * @param aliPayOrderRequest
     * @return
     */
    public AlipayTradePrecreateResponse doPreCreateAilPayOrder(AliPayOrderRequest aliPayOrderRequest) {
        Preconditions.checkArgument(StringUtils.isNotBlank(aliPayOrderRequest.getNotifyUrl()), "notify url 不能为空");
        Preconditions.checkArgument(Objects.nonNull(aliPayOrderRequest.getTotalAmount()), "total_amount 不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(aliPayOrderRequest.getSubject()), "subject 不能为空");
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

        request.setNotifyUrl(aliPayOrderRequest.getNotifyUrl());
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", aliPayOrderRequest.getOutTradeNo());
        bizContent.put("total_amount", aliPayOrderRequest.getTotalAmount().toString());
        bizContent.put("subject", aliPayOrderRequest.getSubject());

        request.setBizContent(bizContent.toString());
        AlipayTradePrecreateResponse response = new AlipayTradePrecreateResponse();
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.error("aliPayService do pre create order error :", e);
        }
        return response;
    }


    private int createPaymentOrder(AliPayOrderRequest aliPayOrderRequest) {
        try {
            PaymentOrder paymentOrder = new PaymentOrder()
                    .setPaymentType(PaymentTypeEnum.ALIPAY_TYPE.getCode())
                    .setPaymentPrice(aliPayOrderRequest.getTotalAmount())
                    .setChannelOrderId(aliPayOrderRequest.getChannelOrderId())
                    .setAccountId(aliPayOrderRequest.getAccountId());
            return paymentOrderMapper.insert(paymentOrder);
        } catch (Exception e) {
            log.error("create payment order fail ", e);
            return 0;
        }

    }
}
