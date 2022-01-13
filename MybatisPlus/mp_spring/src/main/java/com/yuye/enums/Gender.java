package com.yuye.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum  Gender implements IEnum<Integer> {
    MAN(1,"男"),
    WOMAN(2,"女");


    Gender(int sex, String gender) {
        this.sex = sex;
        this.gender = gender;
    }

    private int sex;
    private String gender;
    @Override
    public Integer getValue() {
        return this.sex;
    }

    @Override
    public String toString() {
        return  this.gender ;
    }
}
