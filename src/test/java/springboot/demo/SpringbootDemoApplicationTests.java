package springboot.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.demo.annotation.FruitInfoUtil;
import springboot.demo.bean.Apple;
import springboot.demo.bean.User;
import springboot.demo.mapper.UserMapper;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
    /** Logger实例 */
    static final Logger logger = LoggerFactory.getLogger(SpringbootDemoApplicationTests.class);
    @Autowired
    UserMapper userMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    Environment env;


    @Test
    public void contextLoads() {
        /*int[] a = {1, 2};
        List<Integer> ids = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<User> users = userMapper.selectBatchIds(ids);

        ExcelUtiles.exportExcel(users, "测试名", "什么名字", User.class, "测试.xls", response);*/

        /*int[] a = {1, 2};
        List<Integer> ids = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println(users);*/
    }

     /*@Test
    public void test(){
       OutputStream out = null;
        try {
        out = new FileOutputStream("C:\\file\\门店导出.xlsx");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        try {
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 0, ExcelPropertyIndexModel.class);
        writer.write(getData(), sheet1);
        writer.finish();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    private List<ExcelPropertyIndexModel> getData(){
        List<ExcelPropertyIndexModel> models = new ArrayList<>();
        ExcelPropertyIndexModel moddel = new ExcelPropertyIndexModel();
        moddel.setAddress("jiangxi");
        moddel.setAge("11");
        moddel.setEmail("1");
        moddel.setName("1");
        moddel.setHeigh("1");
        moddel.setSax("1");
        moddel.setLast("1");
        models.add(moddel);
        return models;
    }*/

    @Test
    public void send(){
        rabbitTemplate.convertAndSend("exchange.direct", "queue.test.4", "hehe");
    }

    @Test
    public void receive(){
        rabbitTemplate.receiveAndConvert("queue.test.4");
    }

    @Test
    public void Test1(){
        User user = new User();
        for(int i=0 ;i< 20000; i++){
            user.setAge(i);
            user.setName("test"+i+"");
            user.setSex("1");

            userMapper.insert(user);
        }

    }
    @Test
    public void Test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users.size());
    }

    /**
     * 去掉UUID中的分隔符
     */
    @Test
    public void test3(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println("=================uuid=============是："+uuid);
    }

    /**
     * 自定义注解测试
     * @throws Exception
     */
    @Test
    public void test4()throws Exception{
        FruitInfoUtil.getFruitInfo(Apple.class);
    }

    @Test
    public void test5(){
        logger.info("进入logbackTest方法了！");
        }

}

