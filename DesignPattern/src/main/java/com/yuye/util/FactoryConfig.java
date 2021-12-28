package com.yuye.util;

import com.yuye.factory.configfactory.Coffee;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class FactoryConfig {
    private FactoryConfig() {
    }

    public static class FactoryConfigIn {
        private static HashMap<String, Coffee> map = new HashMap<>();
        static {
            Properties p = new Properties();
            InputStream is = FactoryConfigIn.class.getClassLoader().getResourceAsStream("Bean.properties");
            try {
                p.load(is);
                Set<Object> keys = p.keySet();
                for (Object key : keys) {
                    String name = (String) key;
                    String className = p.getProperty(name);
                    Class<?> clazz = Class.forName(className);
                    Coffee coffee = (Coffee) clazz.newInstance();
                    FactoryConfigIn.map.put(name,coffee);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public static HashMap<String, Coffee> getMap() {
        return FactoryConfigIn.map;
    }
}
