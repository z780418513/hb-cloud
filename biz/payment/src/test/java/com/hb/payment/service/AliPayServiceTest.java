package com.hb.payment.service;

import com.hb.payment.PaymentApp;
import com.hb.payment.bo.AliPayOrderRequest;

import com.hb.payment.bo.AliPayTradeQuery;
import com.hb.payment.enums.PaymentTypeEnum;
import com.hb.payment.service.impl.AliPayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaochengshui
 * @description
 * @date 2022/12/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentApp.class)
public class AliPayServiceTest {
    @Resource
    private AliPayService aliPayService;
    @Resource
    private BasePay basePay;

    @Test
    public void getQrCodeTest() {
        BasePay pay = basePay.getByPaymentType(PaymentTypeEnum.ALIPAY_TYPE);
        String token = pay.generateToken();
        AliPayOrderRequest aliPayOrderRequest = new AliPayOrderRequest();
        aliPayOrderRequest.setSubject("测试商品");
        aliPayOrderRequest.setTotalAmount(new BigDecimal("0.01"));
        aliPayOrderRequest.setNotifyUrl("");
        aliPayOrderRequest.setOutTradeNo("12894348975841123");
        aliPayOrderRequest.setNotifyUrl("http://www.baidu.com");
        aliPayOrderRequest.setAccountId("aaaaa");
        aliPayOrderRequest.setChannelOrderId("1233439895234");
        aliPayOrderRequest.setUuid(token);
        String result = aliPayService.getQrCode(aliPayOrderRequest);
        System.out.println("result = " + result);
    }

    @Test
    public void getQrCodeTest2() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        AliPayOrderRequest aliPayOrderRequest = new AliPayOrderRequest();
        aliPayOrderRequest.setSubject("测试商品");
        aliPayOrderRequest.setTotalAmount(new BigDecimal("0.01"));
        aliPayOrderRequest.setNotifyUrl("");
        aliPayOrderRequest.setOutTradeNo("1289434897584112324");
        aliPayOrderRequest.setNotifyUrl("http://www.baidu.com");
        aliPayOrderRequest.setAccountId("aaaaa");
        aliPayOrderRequest.setChannelOrderId("12334398954");
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->aliPayService.getQrCode(aliPayOrderRequest));
        }
    }

    @Test
    public void getQrCodeTest3() {
        AliPayTradeQuery query = new AliPayTradeQuery();
        query.setOutTradeNo("1289434897584114");
        String result = aliPayService.tradeQuery(query);
    }



    @Test
    public void getQrCodeTest4() {
        BasePay pay = basePay.getByPaymentType(PaymentTypeEnum.ALIPAY_TYPE);
        AliPayTradeQuery query = new AliPayTradeQuery();
        query.setOutTradeNo("1289434897584114");
        String result = pay.tradeQuery(query);
    }
}
