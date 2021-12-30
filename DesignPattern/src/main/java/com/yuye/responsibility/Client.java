package com.yuye.responsibility;

public class Client {
    //程序入口
    public static void main(String[] args) {
        LeaveRequest leaveRequest = new LeaveRequest("张三",8);
        GroupLeader groupLeader = new GroupLeader();
        ProductManager productManager = new ProductManager();
        GeneralManager generalManager = new GeneralManager();
        groupLeader.setNextHandler(productManager);
        productManager.setNextHandler(generalManager);
        groupLeader.audit(leaveRequest);
    }
}
