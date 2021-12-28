package com.yuye.proxy.activeproxy.cglibdemo;

import com.yuye.proxy.activeproxy.jdkdemo.TrainTickets;

public class TrainTicketsSell implements TrainTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
