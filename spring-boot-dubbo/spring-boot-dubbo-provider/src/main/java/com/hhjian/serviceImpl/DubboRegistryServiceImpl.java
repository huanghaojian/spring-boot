package com.hhjian.serviceImpl;


import com.alibaba.dubbo.config.annotation.Service;
import com.hhjian.service.DubboRegistryService;
import com.hhjian.util.NetInterfaceUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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
        String returnMessage = "the message is '" + message + "';";
        String ip = NetInterfaceUtil.getServerIp();
        String mac = NetInterfaceUtil.getServerMac();

        Map<String, String> map = new HashMap<>();
        map.put("Provider Message:", returnMessage);
        map.put("Provider IP:", ip);
        map.put("Provider MAC:", mac);
        return map.toString();
    }
}
