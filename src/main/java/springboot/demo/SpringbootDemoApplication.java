package springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@RestController
//@EnableScheduling
@SpringBootApplication
@MapperScan("springboot.demo.mapper")
//@NacosPropertySource(dataId = "springboot2-nacos-config", autoRefreshed = true)
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

//    @NacosValue(value = "${service.name:123}", autoRefreshed = true)
//    private String serverName;
//
//    @GetMapping("/test")
//    public String test(){
//        return serverName;
//    }


}

