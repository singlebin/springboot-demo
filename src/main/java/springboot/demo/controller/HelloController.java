package springboot.demo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.bean.ResponseBean;
import springboot.demo.enums.UnicomResponseEnums;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/2/27 14:34
 */

@RestController
@ApiIgnore
public class HelloController {

    @CrossOrigin
    @ApiOperation(value = "hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ResponseBean sayHello(){
        System.out.println(10/0);
        //ResponseBean responseBean=new ResponseBean(true,UnicomResponseEnums.SUCCESS_OPTION);
        return new ResponseBean(false, "hehe" , UnicomResponseEnums.ILLEGAL_ARGUMENT);
    }

}
