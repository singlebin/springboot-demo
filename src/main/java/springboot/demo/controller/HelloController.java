package springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.bean.ResponseBean;
import springboot.demo.config.LogUtil;
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
    /**
     * @CrossOrigin 解决跨域
     * @ApiOperation 配合swagger2来使用
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ResponseBean sayHello(){

        ResponseBean responseBean=new ResponseBean(true,UnicomResponseEnums.SUCCESS_OPTION);
        LogUtil.info("返回的结果："+JSON.toJSONString(responseBean));
        return responseBean;
    }

}
