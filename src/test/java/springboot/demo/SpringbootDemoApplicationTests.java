package springboot.demo;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.demo.annotation.FruitInfoUtil;
import springboot.demo.bean.Apple;
import springboot.demo.bean.User;
import springboot.demo.mapper.UserMapper;
import springboot.demo.service.AsyncService;
import springboot.demo.service.UserService;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

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
    @Autowired
    ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    AsyncService asyncService;
    @Autowired
    UserService userService;


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
        long t1 = System.currentTimeMillis();
        List<User> list = new ArrayList<>();
        for(int i=172040 ;i<200000; i++){
            User user = new User();
            user.setAge(i);
            user.setName("test"+i+"");
            user.setSex("1");
            list.add(user);
        }

        userService.saveBatch(list);
        long t2 = System.currentTimeMillis();
        System.out.println("耗时："+(t2-t1));
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
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(wrapper);
        //System.out.println(JSONArray.toJSON(users));
        logger.info("结果为："+JSONArray.toJSON(users));
    }

    @Test
    public void test6()throws Exception{
        /*CompletableFuture<String> completableFuture = new CompletableFuture<>();
        //自己开个线程去执行 执行完把结果告诉completableFuture即可
        new Thread(() -> {
            // 模拟执行耗时任务
            System.out.println("task doing...");
            try {
                Thread.sleep(3000);
                //} catch (InterruptedException e) {
            } catch (Exception e) {
                // 告诉completableFuture任务发生异常了
                completableFuture.completeExceptionally(e);
                e.printStackTrace();
            }
            // 告诉completableFuture任务已经完成 并且把结果告诉completableFuture
            completableFuture.complete("ok");
        }).start();
        // 获取任务结果，如果没有完成会一直阻塞等待
        long t1 = System.currentTimeMillis();
        System.out.println("=======准备打印结果..."+ t1);
        String result = completableFuture.get();
        long t2 = System.currentTimeMillis();
        System.out.println("=========计算结果:" + result + " ,耗时："+(t2-t1));*/

        //asyncService.sayHello("wub");

        // 阻塞调用
        long t1  = System.currentTimeMillis();
        String s1 = asyncService.sayHello("yan").get();
        long t2  = System.currentTimeMillis();
        System.out.println("======="+s1+"  耗时："+(t2-t1));
        // 限时调用
        long t3  = System.currentTimeMillis();
        String s = asyncService.sayHello("yan").get(1, TimeUnit.SECONDS);
        long t4  = System.currentTimeMillis();
        System.out.println("======="+s+"  耗时："+(t4-t3));

    }

    @Test
    public void Test7(){
        //创建ExecutorService，并且通过它向线程池提交任务
        ExecutorService executorService = Executors.newCachedThreadPool();
        //向线程池提交任务
        Callable<Double> callable = new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return doSomeLongTime();
            }
        };
        Future future =  executorService.submit(callable);
        //当前线程继续做其他事情
        //doSomeElse();
        User users = userMapper.selectById(205211L);
            //获取异步操作的结果
        try {
            double result = (double)future.get(1,TimeUnit.SECONDS);
            System.out.println("===========结果为："+result);
        } catch (InterruptedException e) {
            //线程被中断
            e.printStackTrace();
        } catch (ExecutionException e) {
            //线程抛出异常
            e.printStackTrace();
        } catch (TimeoutException e) {
            //线程超时
            e.printStackTrace();
        }
    }

    /**
     * 多任务单次异步执行
     */
    @Test
    public void testManyFunAsync(){
            long start = System.nanoTime();//程序开始时间
            try {
                int id = 1;//模拟一个参数，如学校Id
                System.out.println("调用异步任务...");
                //使用异步方式调用方法【调用时就会开始执行方法】
                CompletableFuture futureClassCount = CompletableFuture.supplyAsync(() -> getClassCount(id));
                CompletableFuture futureStudentCount = CompletableFuture.supplyAsync(() -> getStudentCount(id));

                //do something 做了一些其他的事情超过了异步任务执行的时间
                System.out.println("做一些其他的事情...");
                Thread.sleep(3000);
                System.out.println("其他事情完成");

                //下面获取异步任务的结果，就会立即拿到返回值
                System.out.println("获取异步任务结果...");
                Object classCount = futureClassCount.get();
                //Object classCount = futureClassCount.get(2, TimeUnit.SECONDS);//可以设置超时时间，超过这个时间时将不再等待，返回异常
                Object studentCount = futureStudentCount.get();
                //Object studentCount = futureStudentCount.get(2, TimeUnit.SECONDS);
                System.out.println("异步任务结果获取完成");

                System.out.println("ClassCount:" + classCount);
                System.out.println("StudentCount:" + studentCount);

            } catch (Exception e) {
                e.printStackTrace();
            }
            long end = System.nanoTime();//程序结束时间
            long time = (end - start) / 1000000;//总耗时
            System.out.println("运行时间：" + time);

    }


    @Test
    public void test8(){
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "任务A");
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "任务B");
        CompletableFuture<String> futureC = futureB.thenApplyAsync((b) -> {
            System.out.println("执行任务C.");
            System.out.println("参数:" + b);//参数:任务B
            return "a";
        });


    }


    public int getClassCount(int id) {
        try {
            Thread.sleep(2000);
            System.out.println("getClassCount(" + id + ")执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 20;
    }

    public int getStudentCount(int id) {
        try {
            Thread.sleep(1000);
            System.out.println("getStudentCount(" + id + ")执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100;
    }
    public Double doSomeLongTime(){
        double a = 1;
        double b = 2;
        return a+b;
    }



}

