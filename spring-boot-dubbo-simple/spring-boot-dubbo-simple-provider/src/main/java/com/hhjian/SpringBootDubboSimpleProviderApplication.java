package com.hhjian;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class SpringBootDubboSimpleProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboSimpleProviderApplication.class, args);
	}
}
