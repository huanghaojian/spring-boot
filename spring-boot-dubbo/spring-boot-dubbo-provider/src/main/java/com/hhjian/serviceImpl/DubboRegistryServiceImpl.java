package com.hhjian.serviceImpl;


import com.alibaba.dubbo.config.annotation.Service;
import com.hhjian.dao.UserRepository;
import com.hhjian.domain.User;
import com.hhjian.service.DubboRegistryService;
import com.hhjian.util.NetInterfaceUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    @Override
    public String hello(String message) {
        String returnMessage = "the message is '" + message + "';";
        String ip = NetInterfaceUtil.getServerIp();
        String mac = NetInterfaceUtil.getServerMac();

        User user = new User();
        user.setUsername("huanghaojian");
        user.setAge(20);
        user.setLoginIp(ip);
        user.setLoginMac(mac);
        user.setDesc(returnMessage);

        return user.toString();
    }

    @Override
    public User saveUser(User user) {
        String ip = NetInterfaceUtil.getServerIp();
        String mac = NetInterfaceUtil.getServerMac();

        user.setLoginIp(ip);
        user.setLoginMac(mac);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findOne(id);
    }
}
