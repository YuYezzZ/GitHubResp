package com.yuye.responsibility;

public class LeaveRequest {
    private String name;
    private int day;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public LeaveRequest(String name, int day) {
        this.name = name;
        this.day = day;
    }
}
