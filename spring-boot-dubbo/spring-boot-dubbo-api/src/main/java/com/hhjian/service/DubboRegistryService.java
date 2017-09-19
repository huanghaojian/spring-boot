package com.hhjian.service;

import com.hhjian.domain.User;

/**
 * <p>服务接口</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.12
 */
public interface DubboRegistryService {

    String hello(String message);

    User saveUser(User user);

    User getUser(String id);
}
