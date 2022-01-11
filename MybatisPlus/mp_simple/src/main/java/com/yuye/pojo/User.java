package com.yuye.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
public class User {
    @TableId(value="user_id",type= IdType.AUTO)//对应数据库中的主键名,type属性设置AUTO表示主键自增长，不设置的恶化会跳出一个很大的数
    private Long id;
    private String userName;
    @TableField(select = false)//select可以隐藏查询的信息
    private String password;
    private String name;
    private int age;
    @TableField(value = "email")//对应数据库中的列名
    private String mail;
    @TableField( exist= false) //exist属性可以设置进行CURD操作是否提交该属性
    private String address;

}
