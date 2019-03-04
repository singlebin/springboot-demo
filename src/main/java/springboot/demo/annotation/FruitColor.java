package springboot.demo.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/2/27 10:31
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum  Color{
        BLUE,
        RED,
        GREEN;
    }

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;
}
