package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/2/27 14:34
 */

@RestController
@ApiIgnore
public class HelloController {

//    /**
//     * @CrossOrigin 解决跨域
//     * @ApiOperation 配合swagger2来使用
//     * @return
//     */
//    @CrossOrigin
//    @ApiOperation(value = "hello")
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
//    public ResponseBean sayHello(){
//
//        ResponseBean responseBean=new ResponseBean(true,UnicomResponseEnums.SUCCESS_OPTION);
//        LogUtil.info("返回的结果："+JSON.toJSONString(responseBean));
//        return responseBean;
//    }

    @PostMapping("/test")
    public void test(){

    }

}
