package springboot.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import springboot.demo.bean.User;

import java.util.List;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/1/23 10:07
 */
public interface UserService extends IService<User> {

    public List<User> findUserAll();
}
