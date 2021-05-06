package com.george.spider.app.Exception;

import com.george.spider.app.Controller.BaseController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;


/**
 * @author lazycece
 * @date 2019/02/23
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseController {

    /**
     * 参数校验错误异常
     *
     * @param e MethodArgumentNotValidException|BindException
     * @return ResponseData
     */
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public String bindExceptionHandler(Exception e) {
        BindingResult bindingResult;
        if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        } else {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        }
        StringBuilder stringBuilder = new StringBuilder();
        bindingResult.getAllErrors().forEach(
                objectError ->
                        stringBuilder.append(",").append(objectError.getDefaultMessage())
        );
        String errorMessage = stringBuilder.toString();
        errorMessage = errorMessage.substring(1, errorMessage.length());
        return error(500,errorMessage,bindingResult.getAllErrors());
    }

//    /**
//     * 捕获自定义的统一全局异常
//     *
//     * @param e AbstractGlobalException
//     * @return ResponseData
//     */
//    @ExceptionHandler(value = AbstractGlobalException.class)
//    public ResponseData customExceptionHandler(AbstractGlobalException e) {
//        return ResponseData.builder().code(e.getCode()).message(e.getMessage()).build();
//    }
//
//    /**
//     * 捕获未知异常
//     *
//     * @param e Exception
//     * @return ResponseData
//     */
//    @ExceptionHandler(value = Exception.class)
//    public ResponseData commonExceptionHandler(Exception e) throws ServletException {
//        if (e instanceof ServletException) {
//            throw (ServletException) e;
//        }
//        log.error("server inner error: {}", e);
//        return ResponseData.builder().code(ResCode.FAIL).message(ResMsg.SERVER_INNER_ERROR).build();
//    }
}