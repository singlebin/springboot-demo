package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.demo.service.UserService;

/**
 * @description:
 * @Author: wub
 * @date 2019/12/30 16:20
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public void test(@RequestBody String json){
        System.out.println("json=" + json);
    }


    @GetMapping("/list")
    public String list(){

        return "ok";
    }
}
