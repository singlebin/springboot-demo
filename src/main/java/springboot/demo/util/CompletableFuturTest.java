package springboot.demo.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/3/9 9:47
 */
public class CompletableFuturTest {

    public static void main(String[] args) throws  Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long start = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "商品详情";
        },executorService);

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "卖家信息";
        },executorService);

        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "库存信息";
        },executorService);

        CompletableFuture<String> futureD = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "订单信息";
        },executorService);
        String s = "2";

//        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futureA, futureB, futureC, futureD);
//        allFuture.join();
        //CompletableFuture<Object> allFuture = CompletableFuture.anyOf(futureA, futureB, futureC, futureD);
        //allFuture.join();
        System.out.println(futureA.get() +","+ futureB.get() +","+ futureC.get() +","+ futureD.get());
        //System.out.println("=========="+allFuture.join());
        System.out.println("总耗时:" + (System.currentTimeMillis() - start));

    }


}
