package com.hhjian.controller;

import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import com.hhjian.domain.User;
import com.hhjian.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>用户控制层</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.13
 */
@RestController
public class UserController {

    @DubboConsumer
    private UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return user;
    }

}
