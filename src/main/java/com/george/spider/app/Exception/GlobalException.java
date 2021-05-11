package com.george.spider.app.Exception;


/**
 * @author sssr
 * @version 1.0
 * @Description: 自定义异常类
 * @date 2019/2/20
 */
public class GlobalException extends RuntimeException{
    public GlobalException() {
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }

    public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}