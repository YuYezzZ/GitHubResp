package com.yuye.service;

import com.yuye.util.JedisUtils;
import redis.clients.jedis.Jedis;

/**
 * @Auther: yuye
 * @Date: 2022/2/15 - 02 - 15 - 10:15
 * @Description: com.yuye
 * @version: 1.0
 */
public class Service {
    //业务控制
    public void setTimes(String key,Long num){
        //Jedis jedis = new Jedis("127.0.0.1", 6379);
        Jedis jedis = JedisUtils.getJedis();
        String value = jedis.get(key);
        try {
            if(value != null){
                Long aLong = Long.valueOf(value);
                Long count =  (num-(Long.MAX_VALUE - aLong));
                jedis.incr(key);
                business(key,count+1L);
            }else{
                jedis.setex(key,10,(Long.MAX_VALUE - num+1L)+"");
                business(key,1L);
            }

        } catch (Exception e) {
            System.out.println(key + "使用次数到达上限");
            return;
        } finally {
            jedis.close();
        }
    }
    //业务操作
    public void business(String key,Long count){
        System.out.println(key+":业务操作第"+count+"次执行");
    }
}

class MyThread extends Thread{
        private String key ;
        private Long num;

    public MyThread(String key, Long num) {
        this.key = key;
        this.num = num;
    }

    //业务方法
        public void run(){
            Service service = new Service();
            while (true){
                service.setTimes(key,num);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}

class Main{
    //程序入口
    public static void main(String[] args) {
        MyThread myThread = new MyThread("a",5L);
        myThread.start();
        MyThread myThread2 = new MyThread("b",10L);
        myThread2.start();
        MyThread myThread3 = new MyThread("c",15L);
        myThread3.start();
    }
}

