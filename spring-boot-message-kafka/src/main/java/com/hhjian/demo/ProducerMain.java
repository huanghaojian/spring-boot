package com.hhjian.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 17-9-10.
 */
public class ProducerMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        // acks是判别请求是否为完整的条件(就是是判断是不是成功发送了)。指定了“all”将会阻塞消息，这种设置性能最低，但是是最可靠的。
        props.put("acks", "all");
        // retries，如果请求失败，生产者会自动重试，我们指定是0次，如果启用重试，则会有重复消息的可能性。
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer(props);

        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("segementfault", 0, "message", "你好吗!");

        for (int i = 0; i < 10; i++) {
            Future<RecordMetadata> future = kafkaProducer.send(producerRecord);
            // 由于send调用是异步的，它将为分配消息的此消息的RecordMetadata返回一个Future。
            // 如果future调用get()，则将阻塞，直到相关请求完成并返回该消息的metadata，或抛出发送异常。
            RecordMetadata recordMetadata = future.get();
            System.out.println(recordMetadata);
        }

        kafkaProducer.close();
    }
}
