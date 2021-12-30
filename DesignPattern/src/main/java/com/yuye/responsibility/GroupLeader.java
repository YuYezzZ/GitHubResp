package com.yuye.responsibility;

public class GroupLeader extends Handler{
    public GroupLeader() {
        this.start = 0;
        this.end = NUM_ONE;
    }

    void audit(LeaveRequest leave) {
        if (leave.getDay() <= end) {
            System.out.println("项目经理同意了"+leave.getName()+"请假"+leave.getDay()+"天的申请" );
        }else{
            this.getNextHandler().audit(leave);
        }
    }
}
