package com.hb.yimi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YiMiApp  {

    public static void main(String[] args) {
        System.out.println("YIMI模块---->start");
        SpringApplication.run(YiMiApp.class);
        System.out.println("YIMI模块---->running");
    }
}
