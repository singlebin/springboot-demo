package springboot.demo.service;

/**
 * @description: Rabbitmq发送信息接口
 * @Author: wub
 * @Date: 2019/3/19 17:52
 */
public interface IMessageProducerMQService {

    public void sendMessage(String msg) ;
}
