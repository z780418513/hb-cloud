package com.hb.payment.service;

import com.hb.payment.PaymentApp;
import com.hb.payment.bo.AliPayOrder;

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
    public void pay() {
        AliPayOrder aliPayOrder = new AliPayOrder();
        aliPayOrder.setSubject("测试商品");
        aliPayOrder.setOutTradeNo(new BigDecimal("0.01").toString());
        aliPayOrder.setNotifyUrl("");
        aliPayOrder.setOutTradeNo("1289434897584");
        String result = aliPayService.getQrCode(aliPayOrder);
    }
}
