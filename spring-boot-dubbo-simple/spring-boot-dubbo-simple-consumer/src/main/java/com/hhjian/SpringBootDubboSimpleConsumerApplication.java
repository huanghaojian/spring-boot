package com.hhjian;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class SpringBootDubboSimpleConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboSimpleConsumerApplication.class, args);
	}
}
