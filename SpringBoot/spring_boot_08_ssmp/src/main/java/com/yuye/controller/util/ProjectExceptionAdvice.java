package com.yuye.controller.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R ex1(Exception ex){
        ex.printStackTrace();
        return new R("服务器异常，请联系管理员！");
    }
}
