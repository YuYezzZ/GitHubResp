package com.yuye.flyweight;

import java.util.HashMap;

public class GetBoxFactory {
    private  HashMap<String,AbstractBox> map;

    private GetBoxFactory() {
        map = new HashMap<>();
        map.put("I",new IBox());
        map.put("L",new LBox());
        map.put("T",new TBox());
    }

    public HashMap<String, AbstractBox> getMap() {
        return map;
    }
    public static class BoxFactory{
        private static GetBoxFactory factory = new GetBoxFactory();

        private BoxFactory() {
        }
    }
    public static GetBoxFactory getFactory(){
        return BoxFactory.factory;
    }

}
