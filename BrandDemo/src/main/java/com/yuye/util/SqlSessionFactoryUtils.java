package com.yuye.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: yuye
 * @Date: 2021-12-19 - 12 - 19 - 13:21
 * @Description: com.yuye.util
 * @version: 1.0
 */
public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
