package com.yuye.prototype.Demo1;

public class Client {
     //程序入口
     public static void main(String[] args) {
          Realizetype r = new Realizetype();
          r.setName("张三");
          try {
               Realizetype r2 = (Realizetype) r.clone();
               r2.setName("李四");
               r.show();
               r2.show();
          } catch (CloneNotSupportedException e) {
               e.printStackTrace();
          }

     }
}
