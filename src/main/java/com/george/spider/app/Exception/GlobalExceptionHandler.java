package com.george.spider.app.Exception;

import com.george.spider.app.Response.Response;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author sssr
 * @version 1.0
 * @Description: 异常捕获处理类
 * @date 2019/2/20
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     *
     * @param e
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    public Response globalException(Exception e){
        return Response.error(e.getMessage());
    }

    /**
     * lombok请求参数不合法异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Response bindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String errorMesssage = "";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getDefaultMessage() + "!";
        }
        return Response.error(errorMesssage);
    }

    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Response exception(Exception e){
        return Response.error(e.getMessage());
    }
}