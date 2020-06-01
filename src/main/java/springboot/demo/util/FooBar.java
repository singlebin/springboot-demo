package springboot.demo.util;

/**
 * @description:  启动两个线程, 一个输出 1,3,5,7…99, 另一个输出 2,4,6,8…100 最后 STDOUT 中按序输出 1,2,3,4,5…100
 *          java 多线程编程之：notify 和 wait 用法
 *          Object.wait() —— 暂停一个线程
*           Object.notify() —— 唤醒一个线程
 * @Author: wub
 * @date 2019/10/10 9:28
 */
public class FooBar {
    public static void main(String[] args) {
        Object object = new Object();

        new Thread(() ->{
            synchronized (object){
                for (int i = 0; i <= 100; i+=2){
                    System.out.println(Thread.currentThread().getName()+ "------->" +i);
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        new Thread(() ->{
            synchronized (object){
                for (int i = 1; i < 100; i+=2){
                    System.out.println(Thread.currentThread().getName()+ "------->" + i );
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }
}
