package springboot.demo.service;

import springboot.demo.bean.User;

/**
 * @description:
 * @Author: wub
 * @date 2019/8/20 9:54
 */
@FunctionalInterface
public interface GreetingService {

    User say(String name);
}
