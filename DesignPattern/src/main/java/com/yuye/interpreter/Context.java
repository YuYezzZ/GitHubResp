package com.yuye.interpreter;

import java.util.HashMap;

public class Context {
    private HashMap<String ,Integer> map = new HashMap<>();

    public void assign(Variable variable,Integer value){
        map.put(variable.getName(),value);
    }
    public int getValue(Variable variable){
        Integer integer = map.get(variable.getName());
        return integer;
    }
}
