package com.hhjian.serviceImpl;


import com.alibaba.dubbo.config.annotation.Service;
import com.hhjian.service.DubboRegistryService;
import org.springframework.stereotype.Component;

/**
 * <p>实现DubboRegistryService服务</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.12
 */
@Component
@Service(version = "1.0.0")
public class DubboRegistryServiceImpl implements DubboRegistryService {

    @Override
    public String hello(String message) {
        return "the message is '" + message + "';";
    }
}
