package springboot.demo.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import springboot.demo.bean.Book;

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

    @Scheduled(cron = "00/60 * * * * ?")
    public void send() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String message = UUID.randomUUID().toString();
        Book book = new Book();
        book.setBookName("红楼梦");
        book.setAuthor("hehe");
        book.setId(1);
        ListenableFuture future = kafkaTemplate.send("my-topic1", objectMapper.writeValueAsString(book));
        future.addCallback(o -> System.out.println("send-消息发送成功：" + message), throwable -> System.out.println("消息发送失败：" + message));
    }
}
