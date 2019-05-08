package springboot.demo.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.config.RabbitmqConfig;
import springboot.demo.service.IMessageProducerMQService;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/3/19 17:53
 */
@Service
public class IMessageProducerMQServiceImpl implements IMessageProducerMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String msg) {
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE,
                RabbitmqConfig.ROUTINGKEY, msg);
    }
}
