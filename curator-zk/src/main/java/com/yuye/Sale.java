package com.yuye;

/**
 * @Auther: yuye
 * @Date: 2022/2/25 - 02 - 25 - 8:56
 * @Description: com.yuye
 * @version: 1.0
 */
public class Sale {
    //程序入口
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread = new Thread(ticket,"a");
        Thread thread2 = new Thread(ticket,"b");
        Thread thread3 = new Thread(ticket,"c");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
