package com.hb.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/3/15
 */
@SpringBootApplication
@MapperScan("com.hb.user")
public class UserAppStart {
    public static void main(String[] args) {
        SpringApplication.run(UserAppStart.class, args);
    }
}
