package springboot.demo.bean;

/**
 * @description:
 * @Author: wub
 * @date 2019/8/21 11:02
 */
public class Dog {
//    public Dog() {
//        System.out.println("Dog");
//    }
//    static{
//        System.out.println("super static block");
//    }
//
//    {
//        System.out.println("super block");
//    }

    public String type="父类成员变量赋的值";
    public Dog() {
        System.out.println("父类构造器--type-->"+type);
        type="父类构造器赋的值";
        System.out.println("父类构造器----type--->"+type);
    }

    {
        System.out.println("block---type--->"+type);
        type="父类块赋的值";
    }
}
