package com.hb.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApp {

    public static void main(String[] args) {
        System.out.println("认证模块---->start");
        SpringApplication.run(AuthApp.class);
        System.out.println("认证模块---->running");
    }
}
