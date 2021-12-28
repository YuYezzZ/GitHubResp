package com.yuye.builder.Demo2;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Phone1 phone1 = new Phone1("m1","oled","256g","4500mAh");
        Phone2 phone2 =new  Phone2.Builder().disk("512g")
                                            .cpu("m1x")
                                            .green("lcd")
                                            .power("5000mAh").build();
        System.out.println(phone1);
        System.out.println(phone2);
    }
}
