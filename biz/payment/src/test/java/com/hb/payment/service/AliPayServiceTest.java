package com.hb.payment.service;

import com.hb.payment.PaymentApp;
import com.hb.payment.bo.AliPayOrder;

import com.hb.payment.bo.AliPayTradeQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

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

    @Test
    public void getQrCodeTest() {
        AliPayOrder aliPayOrder = new AliPayOrder();
        aliPayOrder.setSubject("测试商品");
        aliPayOrder.setTotalAmount(new BigDecimal("0.01"));
        aliPayOrder.setNotifyUrl("");
        aliPayOrder.setOutTradeNo("12894348975841123");
        aliPayOrder.setNotifyUrl("http://www.baidu.com");
        String result = aliPayService.getQrCode(aliPayOrder);
    }

    @Test
    public void getQrCodeTest2() {
        AliPayTradeQuery query = new AliPayTradeQuery();
        query.setOutTradeNo("1289434897584114");
        String result = aliPayService.tradeQuery(query);
    }
}
