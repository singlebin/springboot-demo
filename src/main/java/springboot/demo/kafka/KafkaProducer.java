package springboot.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

/**
 * @description: KafkaProducer
 * @Author: wub
 * @Date: 2019/1/7 11:18
 */

@Component
public class KafkaProducer {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Scheduled(cron = "00/1 * * * * ?")
        public void send(){
            String message = UUID.randomUUID().toString();
            ListenableFuture future = kafkaTemplate.send("my-topic1", message);
            future.addCallback(o -> System.out.println("send-消息发送成功：" + message), throwable -> System.out.println("消息发送失败：" + message));

    }
}
