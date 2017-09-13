package com.hhjian.controller;

import com.hhjian.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Kafka Rest Controller</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.11
 */
@RestController
public class KafkaController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/message/send")
    public String sendMessage(@RequestParam String message) {
        kafkaTemplate.send("sf-2", 0, message);
        return message;
    }

    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user) {
        kafkaTemplate.send("sf-users", 0, user);
        return user;
    }

}
