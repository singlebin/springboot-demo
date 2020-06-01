package springboot.demo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author 陈坤
 * @serial 2019/3/5
 */
@Component
@Aspect
@Slf4j
public class ParameterHandle {

    /**
     * 拦截指定方法打印指定参数值
     * 适用于添加 PrintJsonData 注解的方法
     *
     * @param jp jp
     * @author 陈坤
     */
    @Before("@annotation(springboot.demo.annotation.PrintJsonData)")
    public void han(JoinPoint jp) {

        // 获取切入对象
        Class<?> aClass = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        // 取出当前执行方法
        Optional<Method> optional = Stream.of(aClass.getMethods()).filter(l -> l.getName().equals(methodName)).findAny();
        StringBuilder sb = new StringBuilder();
        // 拼接log信息
        sb.append(aClass.getName()).append(".").append(methodName).append("()");

        optional.ifPresent(method -> {
            PrintJsonData printJsonData = method.getAnnotation(PrintJsonData.class);
            int position = printJsonData.paramPosition();
            // 取出当前执行方法所有参数
            Object[] args = jp.getArgs();
            // 判断当前参数位置是否合法
            if (args != null && args.length > position) {
                sb.append(" >>> ").append(printJsonData.value()).append(" >>> data:").append("\n");
                sb.append(args[position]);
                // 打印最终信息
                log.info(sb.toString());
            } else {
                // 所定位参数位置不可用
                log.warn("Class: {} Invalid parameter position: {}", sb, position);
            }
        });
    }

}
