package com.yuye.builder.Demo2;

public class Phone1 {
    private String cpu;
    private String green;
    private String disk;
    private String power;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGreen() {
        return green;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", green='" + green + '\'' +
                ", disk='" + disk + '\'' +
                ", power='" + power + '\'' +
                '}';
    }

    public Phone1(String cpu, String green, String disk, String power) {
        this.cpu = cpu;
        this.green = green;
        this.disk = disk;
        this.power = power;
    }
}
