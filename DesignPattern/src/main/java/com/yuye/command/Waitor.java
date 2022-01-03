package com.yuye.command;

import java.util.ArrayList;
import java.util.List;

public class Waitor {
    private List<Command> commands = new ArrayList<>();
    //添加订单方法
    public void add(Command command){
        commands.add(command);
    }
    //删除订单方法
    public void remove(Command command){
        commands.remove(command);
    }
    //提交订单方法
    public void submit(){
        System.out.println("订单来了");
        for (Command command : commands) {
            command.execute();
        }
    }
}
