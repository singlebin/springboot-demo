package springboot.demo.util;

import springboot.demo.annotation.PrintJsonData;

/**
 * @description:
 * @Author: wub
 * @date 2020/5/7 14:50
 */
public class BeanTest {

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
//        Book bean = context.getBean(Book.class);
//        System.out.println(bean);
//        Map<String, Map<String, String>> map = Collections.singletonMap("requestData", Collections.singletonMap("openId", "openId123"));
//        System.out.println(JSON.toJSONString(map));
        test("1234");
    }


    @PrintJsonData(value = "java")
    public static void test(String json){
        System.out.println(json);
    }
}
