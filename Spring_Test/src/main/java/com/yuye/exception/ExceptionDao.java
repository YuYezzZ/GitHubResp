package com.yuye.exception;

import org.springframework.stereotype.Repository;

@Repository("exceptionDao")
public class ExceptionDao {
    public void show1() throws Exception{
        Object str = "zhangsan" ;
        Integer num = (Integer) str;
    }
    public void show2(){
        System.out.println("抛出类转换异常");

    }
    public void show3(){
        System.out.println("抛出类转换异常");

    }
    public void show4(){
        System.out.println("抛出类转换异常");

    }
    public void show5()throws MyException{
        System.out.println("抛出类转换异常");
        throw new MyException();
    }
}
