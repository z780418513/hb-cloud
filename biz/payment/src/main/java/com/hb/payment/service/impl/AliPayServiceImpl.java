package com.hb.payment.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.hb.payment.bo.AliPayOrder;
import com.hb.payment.bo.AliPayTradeQuery;
import com.hb.payment.bo.BaseOrder;
import com.hb.payment.bo.BaseTradeQuery;
import com.hb.payment.service.AliPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        AlipayTradePrecreateResponse response = doPreCreateOrder(order);
        if (response.isSuccess()) {
            return response.getQrCode();
        }
        return "";
    }

    @Override
    public String tradeQuery(BaseTradeQuery tradeQuery) {
        AlipayTradeQueryRequest request = createTradeQueryRequest(tradeQuery);
        AlipayTradeQueryResponse response;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()){
            return response.getBody();
        }
        return null;
    }

    public AlipayTradeQueryRequest createTradeQueryRequest(BaseTradeQuery tradeQuery){
        AliPayTradeQuery aliPayTradeQuery = (AliPayTradeQuery) tradeQuery;
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", aliPayTradeQuery.getOutTradeNo());
        bizContent.put("trade_no", aliPayTradeQuery.getTradeNo());

        request.setBizContent(bizContent.toString());
        return request;
    }


    private AlipayTradePrecreateRequest preCreatRequest(BaseOrder order) {
        AliPayOrder aliPayOrder = (AliPayOrder) order;
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

        request.setNotifyUrl(aliPayOrder.getNotifyUrl());

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", aliPayOrder.getOutTradeNo());
        bizContent.put("total_amount", aliPayOrder.getTotalAmount().toString());
        bizContent.put("subject", aliPayOrder.getSubject());

        request.setBizContent(bizContent.toString());
        return request;
    }

    public AlipayTradePrecreateResponse doPreCreateOrder(BaseOrder order) {
        AlipayTradePrecreateRequest request = preCreatRequest(order);
        AlipayTradePrecreateResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return response;
    }
}
