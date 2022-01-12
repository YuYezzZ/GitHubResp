package com.yuye.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.ArrayList;
import java.util.List;

public class MyInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        ArrayList<AbstractMethod> list = new ArrayList<>();
        list.addAll(super.getMethodList());
        list.add(new FindAll());
        return  list;
        /*return (List) Stream.of(new FindAll()).collect(Collectors.toList());*/
    }
}
