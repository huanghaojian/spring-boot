package com.hhjian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboProviderApplication.class, args);
        throw new RuntimeException("黃豪健测试中!!!!!!");
    }
}
