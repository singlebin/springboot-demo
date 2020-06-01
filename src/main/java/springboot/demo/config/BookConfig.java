package springboot.demo.config;

import org.springframework.context.annotation.Bean;
import springboot.demo.bean.Book;

/**
 * @description:
 * @Author: wub
 * @date 2020/5/7 14:48
 */
public class BookConfig {

    @Bean
    public Book book(){
        return new Book(1, "西游记","吴承恩");
    }
}
