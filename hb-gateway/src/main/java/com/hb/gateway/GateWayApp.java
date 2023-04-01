package com.hb.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class GateWayApp {

    public static void main(String[] args) {
        log.info("网关模块---->start");
        SpringApplication.run(GateWayApp.class);
        log.info("网关模块---->running");
    }
}
