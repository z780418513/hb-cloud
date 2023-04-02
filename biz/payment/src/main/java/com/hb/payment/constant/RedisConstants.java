package com.hb.payment.constant;

/**
 * @author zhaochengshui
 * @description redis常量
 * @date 2023/4/2
 */
public class RedisConstants {

    public static final String LOCK_PAY_UUID = "payment:pay:uuid:%s";
    public static final String PAY_TOKEN = "payment:pay:token:%s";
}
