package springboot.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/3/5 11:02
 */
public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void debug(String obj) {
        logger.debug(obj);
    }

    public static void debug(String format, String arg1, String arg2) {
        logger.debug(format, arg1, arg2);
    }

    public static void info(String obj) {
        logger.info(obj);
    }

    public static void info(String format, String arg1, String arg2) {
        logger.info(format, arg1, arg2);
    }

    public static void warn(String obj) {
        logger.warn(obj);
    }

    public static void warn(String format, String arg1, String arg2) {
        logger.warn(format, arg1, arg2);
    }

    public static void error(String obj) {
        logger.error(obj);
    }

    public static void error(Throwable t) {
        logger.error("", t);
    }


    public static void error(String format, String arg1, String arg2) {
        logger.error(format, arg1, arg2);
    }

    public static void error(String format, String arg1) {
        logger.error(format, arg1);
    }

    public static void error(String msg, Throwable t) {logger.error(msg, t);}

}
