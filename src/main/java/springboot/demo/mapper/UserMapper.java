package springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import springboot.demo.bean.User;

import java.util.List;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/1/15 15:09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    public List<User> selectAll();

}
