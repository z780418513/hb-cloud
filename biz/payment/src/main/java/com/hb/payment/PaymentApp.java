package com.hb.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaochengshui
 * @description
 * @date 2022/12/11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApp {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApp.class,args);
    }
}
