package springboot.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * @description: DirectConfig
 * @Author: wub
 * @Date: 2019/1/5 17:27
 */
public class DirectConfig {

    @Bean("queue.test.1")
    public Queue test1(){
        return new Queue("queue.test.1", true);
    }

    @Bean
    public Queue test2(){
        return new Queue("queue.test.2", true);
    }

    @Bean
    public Queue test3(){
        return new Queue("queue.test.3", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("amq.direct", true, false);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(test1()).to(directExchange()).with("queue.test.1");
    }
}
