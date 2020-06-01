package springboot.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springboot.demo.bean.User;
import springboot.demo.mapper.UserMapper;
import springboot.demo.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/1/23 10:08
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserAll() {
        int[] ids = {1, 2};
        List<Integer> collect = Arrays.stream(ids).boxed().collect(Collectors.toList());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //userMapper.selectList(wrapper)
        return userMapper.selectBatchIds(collect);
    }
}
