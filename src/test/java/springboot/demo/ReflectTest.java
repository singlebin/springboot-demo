package springboot.demo;

import org.junit.Test;
import springboot.demo.bean.Book;

import java.lang.reflect.Field;

/**
 * @description: 反射测试
 * @Author: wub
 * @date 2020/4/29 15:10
 */
public class ReflectTest {

    @Test
    public void test() throws Exception {
        Class clazz = Book.class;
        Field bookName = clazz.getDeclaredField("bookName");


    }
}
