package springboot.demo.exception;

import org.apache.ibatis.binding.BindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import springboot.demo.bean.ResponseBean;
import springboot.demo.enums.UnicomResponseEnums;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;
import java.net.ConnectException;
import java.sql.SQLException;

/**
 * @description: 全局的异常处理类
 * @Author: wub
 * @Date: 2019/2/27 14:29
 */
@RestControllerAdvice
public class SpringExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandle.class);
    /**
     * 请求参数类型错误异常的捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value={BindException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ResponseBean<String> badRequest(BindException e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new ResponseBean<>(false, UnicomResponseEnums.BAD_REQUEST);
    }

    /**
     * 404错误异常的捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value={NoHandlerFoundException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public ResponseBean<String> badRequestNotFound(BindException e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new ResponseBean<>(false,null, UnicomResponseEnums.NOT_FOUND);
    }

    /**
     * mybatis未绑定异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindingException.class)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<String> mybatis(Exception e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new ResponseBean<>(false,UnicomResponseEnums.BOUND_STATEMENT_NOT_FOUNT);
    }
    /**
     * 自定义异常的捕获
     * 自定义抛出异常。统一的在这里捕获返回JSON格式的友好提示。
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value={UnicomRuntimeException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> ResponseBean<T> sendError(UnicomRuntimeException exception, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        logger.error("occurs error when execute url ={} ,message {}",requestURI,exception.getMsg());
        return new ResponseBean<>(false,exception.getCode(),exception.getMsg());
    }
    /**
     * 数据库操作出现异常
     * @param e
     * @return
     */
    @ExceptionHandler(value={SQLException.class, DataAccessException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<String> systemError(Exception e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new ResponseBean<>(false, UnicomResponseEnums.DATABASE_ERROR);
    }
    /**
     * 网络连接失败！
     * @param e
     * @return
     */
    @ExceptionHandler(value={ConnectException.class})
    @ResponseBody
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<String> connect(Exception e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new ResponseBean<>(false, UnicomResponseEnums.CONNECTION_ERROR);
    }

    @ExceptionHandler(value={Exception.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseBean<String> notAllowed(Exception e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new ResponseBean<>(false, UnicomResponseEnums.METHOD_NOT_ALLOWED);
    }

}
