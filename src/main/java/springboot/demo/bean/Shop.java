package springboot.demo.bean;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/3/8 16:32
 */
public class Shop {

    private String name;
    private Random random = new Random();

    public Shop(String name) {
        this.name = name;
    }

    //直接获取价格
    public double getPrice(String product){
        return calculatePrice(product);
    }
    //模拟延迟
    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //模拟获取价格的服务
    private double calculatePrice(String product){
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    //异步获取价格
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            future.complete(price);
        }).start();
        return future;
    }

    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.currentTimeMillis();
        Future<Double> future = shop.getPriceAsync("My Favorite");
        long invocationTime = System.currentTimeMillis() - start;
        System.out.println("调用接口时间：" + invocationTime + "毫秒");

        //doSomethingElse();

        try {
            double price = future.get();
            System.out.println("============返回结果为："+price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = System.currentTimeMillis() - start;
        System.out.println("返回价格消耗时间：" + retrievalTime + "毫秒");
    }
}
