package springboot.demo.util;

/**
 * @description:
 * @Author: wub
 * @date 2020/4/30 10:27
 */
public class ThreadLocalTest {


    public static ThreadLocal<Long> x = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            System.out.println("InitialValue is run..");
            return Thread.currentThread().getId();
        }
    };

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("x1 = " + x.get());
            }
        }.start();
        x.set(123L);
        x.remove();
        System.out.println("x = " + x.get());
    }
}
