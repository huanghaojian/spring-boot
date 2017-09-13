package com.hhjian.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hhjian.domain.User;
import com.hhjian.service.UserService;
import org.springframework.stereotype.Component;

/**
 * <p>用户业务实现类</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.13
 */
@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setUsername("hhjian" + id);
        user.setPassword("123");
        return user;
    }
}
