package springboot.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @description: KafkaConsumer
 * @Author: wub
 * @Date: 2019/1/7 11:26
 */
@Component
public class KafkaConsumer {

    //@KafkaListener(topics = "my-topic1")
    public void receive(ConsumerRecord<?,?> consumerRecord){

        Optional<?> kafkaMessqge = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessqge.isPresent()){
            Object message = kafkaMessqge.get();
            System.out.println("kafka接受到的消息："+message);
        }
    }
}
