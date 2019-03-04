package springboot.demo.exception;

import springboot.demo.enums.UnicomResponseEnums;

/**
 * @description: 自定义异常
 * @Author: wub
 * @Date: 2019/2/27 14:26
 */
public class UnicomRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    protected String code;

    protected String msg;
    /**
     * 打印出的日志信息
     */
    protected String message;

    public UnicomRuntimeException(UnicomResponseEnums enums, String message) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.message = message;
    }

    public UnicomRuntimeException(UnicomResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UnicomRuntimeException() {
        super();
    }

    public UnicomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnicomRuntimeException(String message) {
        super(message);
    }

}
