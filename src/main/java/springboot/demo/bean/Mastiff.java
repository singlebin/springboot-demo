package springboot.demo.bean;

/**
 * @description:
 * @Author: wub
 * @date 2019/8/21 11:02
 */
public class Mastiff extends Dog{
//    public Mastiff() {
//        System.out.println("Mastiff");
//    }
//
//    {
//        System.out.println("block");
//    }
//    static {
//        System.out.println("static block");
//    }
//
//    public static void  main(String[] args){
//        Mastiff mastiff=new Mastiff();
//
//    }
public String type="成员变量赋的值";
    public Mastiff() {
        System.out.println("构造器---type--->"+type);
        type="构造器赋的值";
    }

    public void say(){
        System.out.println("say---type---->"+type);
    }

    {
        System.out.println("block---type--->"+type);
        type="块赋的值";

    }

    public static void  main(String[] args){
        Mastiff mastiff=new Mastiff();
        mastiff.say();
    }
}
