package springboot.demo.design;

/**
 * @description: 单例模式
 * @Author: wub
 * @date 2020/4/24 9:18
 */
public class Singleton {

    //1、饿汉模式
//    public Singleton() {}
//    private static Singleton instance = new Singleton();
//
//    pubic static Singleton getInstance(){
//        return instance;
//    }
    //2、饱汉模式（双重检查，指的是两次检查 instance 是否为 null）
//    public Singleton() {}
//    private static volatile  Singleton instance;
//
//    public static Singleton getInstance(){
//        if (instance == null) {
//            synchronized (Singleton.class){
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    //3、嵌套类
    private Singleton() {}
    // 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法 的特性
    private static class Holder {
        private static Singleton instance = new Singleton();
    }
    public static Singleton getInstance() {
        return Holder.instance;
    }

}
