package com.yuye.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static class MybatisUtilHide{
        private static SqlSessionFactory sqlSessionFactory;
        static{
            InputStream resourceAsStream = null;
            try {
                resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
                SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
                sqlSessionFactory = build;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private MybatisUtil() {
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return MybatisUtilHide.sqlSessionFactory;
    }
}
