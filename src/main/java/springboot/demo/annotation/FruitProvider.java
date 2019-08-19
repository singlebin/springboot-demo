package springboot.demo.annotation;

import java.lang.annotation.*;

/**
 * @description: 声明的此注解使用了Inherited元注解，表示此注解用在类上时，会被子类所继承
 * @Author: wub
 * @Date: 2019/2/27 10:40
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FruitProvider {
    /**
     * 供应商编号
     * @return
     */
    int id() default -1;

    /**
     * 供应商名称
     * @return
     */
    String name() default "";

    /**
     * 供应商地址
     * @return
     */
    String address() default "";

}
