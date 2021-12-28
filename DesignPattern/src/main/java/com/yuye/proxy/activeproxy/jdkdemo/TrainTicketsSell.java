package com.yuye.proxy.activeproxy.jdkdemo;

public class TrainTicketsSell implements TrainTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
