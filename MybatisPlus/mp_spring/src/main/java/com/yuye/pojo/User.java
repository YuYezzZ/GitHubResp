package com.yuye.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.yuye.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("tb_user") 配置文件中设置了tableName通配符
//继承model类可以开启activeRecord 可以直接通过对象调用crud方法  user.update
public class User extends Model<User> {
    @TableId(value="user_id" /*,type= IdType.AUTO*/)//对应数据库中的主键名,type属性设置AUTO表示主键自增长，不设置的恶化会跳出一个很大的数
    private Long id;
    private String userName;
    @TableField(select = false)//select可以隐藏查询的信息
    private String password;
    private String name;
    private Integer age;
    @TableField(value = "email")//对应数据库中的列名
    private String mail;
    @TableField( exist= false) //exist属性可以设置进行CURD操作是否提交该属性
    private String address;
    @Version //乐观锁必须配置version注解
    private Integer version;
    @TableLogic//逻辑删除必须配置tableLogic注解
    private Integer deleted;
    private Gender sex;
}
