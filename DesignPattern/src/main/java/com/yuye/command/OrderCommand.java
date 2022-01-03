package com.yuye.command;

public class OrderCommand implements Command{
    private Cooker cooker;
    private Order order;

    public OrderCommand(Cooker cooker, Order order) {
        this.cooker = cooker;
        this.order = order;
    }

    @Override
    public void execute() {
        cooker.cook(order);
    }
}
