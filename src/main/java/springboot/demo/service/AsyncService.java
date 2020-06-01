package springboot.demo.service;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @description: 异步service
 * @Author: wub
 * @Date: 2019/3/8 11:05
 */
@Service
public class AsyncService {

//    @Async
//    public void sayHello(String name) {
//        LoggerFactory.getLogger(AsyncService.class).info(name + ":Hello World!");
//    }

    @Async("asyncHelloPool")
    public ListenableFuture<String> sayHello(String name) {
        String res = name + ":Hello World!";
        LoggerFactory.getLogger(AsyncService.class).info(res);
        return new AsyncResult<>(res);
    }

}
