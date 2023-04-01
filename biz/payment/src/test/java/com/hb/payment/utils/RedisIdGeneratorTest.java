package com.hb.payment.utils;

import com.hb.payment.PaymentApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentApp.class)
public class RedisIdGeneratorTest {
    @Resource
    private RedisIdWorker redisIdGenerator;

    @Test
    public void nextId() {
        long aa = redisIdGenerator.nextId("aa");
        System.out.println("aa = " + aa);
        long bb = redisIdGenerator.nextId("aa");
        System.out.println("bb = " + bb);
    }
}
