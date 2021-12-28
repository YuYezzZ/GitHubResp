package com.yuye.proxy.staticproxy;

public class Proxy implements TrainTickets{
    private TrainTicketsSell trainTicketsSell = new TrainTicketsSell();
    @Override
    public void sell() {
        System.out.println("收取代理费！");
        trainTicketsSell.sell();
    }
}
