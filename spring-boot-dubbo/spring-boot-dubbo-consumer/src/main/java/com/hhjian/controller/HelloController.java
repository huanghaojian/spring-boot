package com.hhjian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hhjian.service.DubboRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>控制层消费者</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.13
 */
@RestController
public class HelloController {
    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Reference(version = "1.0.0")
    private DubboRegistryService helloService;

    @GetMapping("/message")
    public String hello(@RequestParam String message) {
        String result = helloService.hello(message);
        LOGGER.info(result);
        return result;
    }
}
