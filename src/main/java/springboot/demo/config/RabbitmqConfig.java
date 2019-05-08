package springboot.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @description: RabbitmqConfig
 * @Author: wub
 * @Date: 2019/1/5 17:24
 */
@Configuration
public class RabbitmqConfig {

    // 交换空间名称
    public static final String EXCHANGE = "study.microboot.exchange";
    // 设置路由key
    public static final String ROUTINGKEY = "study.microboot.routingkey";
    // 队列名称
    public static final String QUEUE_NAME = "study.microboot.queue";

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding bindingExchangeQueue(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY) ;
    }

    /**
     * 点对点模式
     * @return
     */
    @Bean
    public DirectExchange getDirectExchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    /*@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(1024L * 1024L);
        return factory.createMultipartConfig();
    }*/
}
