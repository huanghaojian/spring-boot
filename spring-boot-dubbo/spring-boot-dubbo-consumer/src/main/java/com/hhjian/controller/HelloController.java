package com.hhjian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hhjian.service.DubboRegistryService;
import com.hhjian.util.NetInterfaceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity hello(@RequestParam String message) {
        String result = helloService.hello(message);
        String ip = NetInterfaceUtil.getServerIp();
        String mac = NetInterfaceUtil.getServerMac();

        Map<String, String> map = new HashMap<>();
        map.put("Message:", result);
        map.put("SERVER IP:", result);
        map.put("SERVER MAC:", result);

        LOGGER.info("SERVER IP:" + ip);
        LOGGER.info("SERVER MAC:" + mac);
        LOGGER.info("Message:" + result);

        ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.OK);
        return responseEntity;
    }
}
