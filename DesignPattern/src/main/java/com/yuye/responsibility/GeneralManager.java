package com.yuye.responsibility;

public class GeneralManager extends Handler {
    void audit(LeaveRequest leave) {
        if (leave.getDay() <= end) {
            System.out.println("总经理同意了" + leave.getName() + "请假" + leave.getDay() + "天的申请");
        } else {
            System.out.println("不予同意");
        }
    }
    public GeneralManager() {
        this.start = NUM_THREE;
        this.end = NUM_SEVEN;
    }
}
