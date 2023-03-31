package com.hb.payment.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.google.common.base.Preconditions;
import com.hb.payment.bo.AliPayOrder;
import com.hb.payment.bo.AliPayTradeQuery;
import com.hb.payment.bo.BaseOrder;
import com.hb.payment.bo.BaseTradeQuery;
import com.hb.payment.service.AliPayService;
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
@Service
@Slf4j
public class AliPayServiceImpl implements AliPayService {
    @Resource
    private AlipayClient alipayClient;

    @Override
    public String getQrCode(BaseOrder order) {
        log.info("aliPayService get qrCode , order : {}", order);
        String qrCodeUrl = "";
        // 创建预订单
        AlipayTradePrecreateResponse response = doPreCreateAilPayOrder(order);
        if (response.isSuccess()) {
            qrCodeUrl = response.getQrCode();
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
     * @param order
     * @return
     */
    public AlipayTradePrecreateResponse doPreCreateAilPayOrder(BaseOrder order) {
        Preconditions.checkArgument(Objects.nonNull(order), "order 不能为空");
        AliPayOrder aliPayOrder = (AliPayOrder) order;
        Preconditions.checkArgument(StringUtils.isNotBlank(aliPayOrder.getNotifyUrl()), "notify url 不能为空");
        Preconditions.checkArgument(Objects.nonNull(aliPayOrder.getTotalAmount()), "total_amount 不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(aliPayOrder.getSubject()), "subject 不能为空");
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

        request.setNotifyUrl(aliPayOrder.getNotifyUrl());
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", aliPayOrder.getOutTradeNo());
        bizContent.put("total_amount", aliPayOrder.getTotalAmount().toString());
        bizContent.put("subject", aliPayOrder.getSubject());

        request.setBizContent(bizContent.toString());
        AlipayTradePrecreateResponse response = new AlipayTradePrecreateResponse();
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.error("aliPayService do pre create order error :", e);
        }
        return response;
    }
}
