package springboot.demo.annotation;

import java.lang.annotation.*;

/**
 * Controller 入参Json数据打印
 * <p>
 * 格式:
 * 方法全路径 + value + json:{data}
 *
 * @author 陈坤
 * @serial 2019/3/5
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrintJsonData {
    /**
     * 对当前打印数据的一段描述
     *
     * @return ""
     */
    String value() default "入参数据:";

    /**
     * 需要获取参数的位置 默认0, 从零开始
     *
     * @return .
     */
    int paramPosition() default 0;

}
