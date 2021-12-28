package com.yuye.builder.Demo1;

public class Director {
    /*private static Builder builder = new MtBuilder();*/
    private static Builder builder = new HelloBuilder();
    static Bike creatBike(){
        Bike bike = new Bike();
        bike.setPartA(builder.createPartA());
        bike.setPartB(builder.createPartB());
        return bike;
    }
}
