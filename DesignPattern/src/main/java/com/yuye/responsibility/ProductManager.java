package com.yuye.responsibility;

public class ProductManager extends Handler {
    void audit(LeaveRequest leave) {
        if (leave.getDay() <= end) {
            System.out.println("产品经理同意了" + leave.getName() + "请假" + leave.getDay() + "天的申请");
        } else {
            this.getNextHandler().audit(leave);
        }
    }

    public ProductManager() {
        this.start = NUM_ONE;
        this.end = NUM_THREE;
    }
}
