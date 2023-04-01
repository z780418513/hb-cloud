package com.hb.payment.mapper;

import com.hb.payment.PaymentApp;
import com.hb.payment.enums.PaymentTypeEnum;
import com.hb.payment.model.PaymentOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentApp.class)
public class PaymentOrderMapperTest {
    @Resource
    private PaymentOrderMapper paymentOrderMapper;

    @Test
    public void insert(){
        PaymentOrder order = new PaymentOrder();
        order.setChannelOrderId("cdyy123456");
        order.setAccountId(133943L);
        order.setPaymentPrice(new BigDecimal("1.00"));
        order.setPaymentType(PaymentTypeEnum.ALIPAY_TYPE.code);
        int insert = paymentOrderMapper.insert(order);
        System.out.println("insert = " + insert);
    }
}
