package springboot.demo.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/2/27 10:25
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface FruitName {
    String value() default  "";
}
