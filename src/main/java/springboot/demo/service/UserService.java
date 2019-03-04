package springboot.demo.service;

import springboot.demo.bean.User;

import java.util.List;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/1/23 10:07
 */
public interface UserService {

    public List<User> findUserAll();
}
