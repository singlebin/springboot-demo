
package springboot.demo.controller;


/**
 * @description:
 * @Author: wub
 * @Date: 2019/1/15 15:18
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.bean.User;
import springboot.demo.mapper.UserMapper;
import springboot.demo.util.ExcelUtiles;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Excel")
public class ExcelController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/exportTest")
    public void exportTest(HttpServletResponse response){
        System.out.println("1   ");
        int[] a = {1, 2};
        List<Integer> ids = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<User> users = userMapper.selectBatchIds(ids);

        ExcelUtiles.exportExcel(users, "测试名", "什么名字", User.class, "测试.xls", response);
    }
}

