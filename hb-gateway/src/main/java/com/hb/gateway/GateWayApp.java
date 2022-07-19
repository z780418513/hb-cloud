package com.hb.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GateWayApp {

    public static void main(String[] args) {
        System.out.println("网关模块---->start");
        SpringApplication.run(GateWayApp.class);
        System.out.println("网关模块---->running");
    }
}
