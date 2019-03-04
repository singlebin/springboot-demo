package springboot.demo.annotation;

import java.lang.annotation.*;

/**
 * @description:
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
    public int id() default -1;

    /**
     * 供应商名称
     * @return
     */
    public String name() default "";

    /**
     * 供应商地址
     * @return
     */
    public String address() default "";

}
