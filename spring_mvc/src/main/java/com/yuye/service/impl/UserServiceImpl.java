package com.yuye.service.impl;

import com.yuye.dao.UserDao;
import com.yuye.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.yuye.service.impl.UserServiceImpl">
@Service("userService")
//@Component("userService")
//@Scope("prototype")
 @Scope("singleton")
public class UserServiceImpl implements UserService {
    //<property name="userDao" ref="userDao"></property>
//    @Autowired           //按照数据类型从Spring容器中进行匹配 如果有多个Bean（UserDao实现类）就得结合@Qualifier使用
//    @Qualifier("userDao")  //按照id从容器中匹配的 但是主要结合@Autowired 一起使用
    @Resource(name="userDao") //相当于@Autowired 和 @Qualifier 结合
    private UserDao userDao;

    //@Value("yuye")
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public UserDao getUserDao() {
        return userDao;
    }
    //注解方式可以省略set方法
    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    public void save() {
        System.out.println("UserServiceImpl");
        System.out.println(driver);
        userDao.save();
    }

    //初始化方法
    @PostConstruct
    public void init(){
        System.out.println("初始化方法");
    }
    //销毁方法
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法");
    }
}
