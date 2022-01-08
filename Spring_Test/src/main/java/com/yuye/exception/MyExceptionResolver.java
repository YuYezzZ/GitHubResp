package com.yuye.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mav = new ModelAndView();
        if(ex instanceof ClassCastException){
            mav.addObject("msg","类型转换异常");
        }else if(ex instanceof MyException){
            mav.addObject("msg","自定义异常");
        }else{
            mav.addObject("msg","请联系管理员");
        }
        mav.setViewName("error3");
        return mav;
    }
}
