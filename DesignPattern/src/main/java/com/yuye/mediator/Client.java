package com.yuye.mediator;

public class Client {
    //程序入口
    public static void main(String[] args) {
        MediatorImpl mediator = new MediatorImpl();
        Tenant tenant = new Tenant("张三",mediator);
        HouseOwner houseOwner = new HouseOwner("李四",mediator);
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);
        tenant.constract("我要租房");
        houseOwner.constract("我有房子");
    }
}
