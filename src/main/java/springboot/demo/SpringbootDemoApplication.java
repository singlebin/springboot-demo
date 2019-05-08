package springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("springboot.demo.mapper")
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        //System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}

