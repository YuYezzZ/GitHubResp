package com.yuye.util;

import com.sun.corba.se.spi.servicecontext.MaxStreamFormatVersionServiceContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @Auther: yuye
 * @Date: 2022/2/15 - 02 - 15 - 11:21
 * @Description: com.yuye.util
 * @version: 1.0
 */
public class JedisUtils {
    public static Jedis getJedis(){
        ResourceBundle redis = ResourceBundle.getBundle("redis");
        String host = redis.getString("jedis.host");
        Integer port = Integer.valueOf(redis.getString("jedis.port"));
        Integer maxTotal = Integer.valueOf(redis.getString("jedis.maxTotal"));
        Integer maxIdle = Integer.valueOf(redis.getString("jedis.maxIdle"));
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port);
        return jedisPool.getResource();
    }
}
