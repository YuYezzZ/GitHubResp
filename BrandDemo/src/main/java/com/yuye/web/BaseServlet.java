package com.yuye.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet", value = "/BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }



    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int i = uri.lastIndexOf("/");
        String substring = uri.substring(i + 1,uri.length());
        Class<? extends BaseServlet> servletClass = this.getClass();
        Method method = null;
        try {
            method = servletClass.getMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
            BaseServlet baseServlet = servletClass.newInstance();
            method.invoke(baseServlet,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
