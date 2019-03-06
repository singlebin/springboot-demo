//package springboot.demo.config;
//
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//
//
///**
// * @description:
// * @Author: wub
// * @Date: 2019/3/4 20:19
// */
//@Aspect
//@Component
//public class LogAspect {
//
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    private Logger logger = LoggerFactory.getLogger("REQUEST_FILE");
//
//    private Logger logger_ex = LoggerFactory.getLogger("EXCEPTION_FILE");
//
//    /**
//     * 第一个*表示返回类型不限，第二个*表示所有类，第三个*表示所有方法, ..两个点表示方法里的参数不限
//     */
//    @Pointcut("execution(* springboot.demo.controller ..*.*(..)))")
//    public void logAroud(){
//
//    }
//    @Around("logAroud()")
//    public void logController(ProceedingJoinPoint proceedingJoinPoint){
//        //时间
//        long start = System.currentTimeMillis();
//        //接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        // 记录下请求内容
//        logger.info("请求开始----"+ sdf.format(new Date()));
//        logger.info("URL : " + request.getRequestURL());
//        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD : " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "_" + proceedingJoinPoint.getSignature().getName());
//        logger.info("ARGS : " + Arrays.toString(proceedingJoinPoint.getArgs()));
//        try {
//            proceedingJoinPoint.proceed();
//            long end = System.currentTimeMillis();
//            logger.info("请求结束----"+sdf.format(new Date())+";耗时"+(end-start)+"毫秒");
//        } catch (Throwable throwable) {
//            logger_ex.info("URL : " + request.getRequestURL());
//            logger_ex.info("IP : " + request.getRemoteAddr());
//            logger_ex.info("CLASS_METHOD : " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "_" + proceedingJoinPoint.getSignature().getName());
//            logger_ex.warn("出现异常"+sdf.format(new Date()),throwable);
//        }
//    }
//
//
//}
