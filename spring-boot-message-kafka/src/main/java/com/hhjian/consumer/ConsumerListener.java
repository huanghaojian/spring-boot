package com.hhjian.consumer;

import com.hhjian.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * <p>消费者监听器</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.11
 */
@Component
public class ConsumerListener {

    /**
     * 消费主题为"sf-2"的信息
     *
     * @param message
     */
    @KafkaListener(topics = "sf-2")
    public void consumer(String message) {
        System.out.println(message);
    }

    /**
     * 消费主题为"sf-users"的信息
     *
     * @param user
     */
    @KafkaListener(topics = "sf-users")
    public void consumer(User user) {
        System.out.println(user);
    }

}
