package com.yuye.builder.Demo2;

public class Phone2 {
    private String cpu;
    private String green;
    private String disk;
    private String power;


    @Override
    public String toString() {
        return "Phone2{" +
                "cpu='" + cpu + '\'' +
                ", green='" + green + '\'' +
                ", disk='" + disk + '\'' +
                ", power='" + power + '\'' +
                '}';
    }

    private Phone2(Builder builder) {
        this.cpu = builder.cpu;
        this.green = builder.green;
        this.disk = builder.disk;
        this.power = builder.power;
    }

    //获取Phone2对象

    public static class Builder{
        private String cpu;
        private String green;
        private String disk;
        private String power;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return  this;
        }
        public Builder green(String green) {
            this.green = green;
            return  this;
        }
        public Builder disk(String disk) {
            this.disk = disk;
            return  this;
        }
        public Builder power(String power) {
            this.power = power;
            return  this;
        }

        //获取Phone2对象
        public Phone2 build(){
            return new Phone2(this);
        }
    }
}
