package com.hhjian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hhjian.domain.User;
import com.hhjian.service.DubboRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>控制层消费者</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.13
 */
@RestController
public class HelloController {
    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Reference(version = "1.0.1")
    private DubboRegistryService helloService;

    @GetMapping("/message")
    public ResponseEntity hello(
            HttpServletRequest request,
            @RequestParam String message) {
        String result = helloService.hello(message);
        ResponseEntity responseEntity = new ResponseEntity(result, HttpStatus.OK);
        LOGGER.info("request ip:" + request.getRemoteHost());
        LOGGER.info("message:" + message);
        return responseEntity;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        User user = helloService.getUser(id);
        LOGGER.info("getUser:" + user);
        return user;
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        LOGGER.info("save users:" + user);
        return helloService.saveUser(user);
    }
}
