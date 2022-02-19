package com.yuye.controller;


import com.yuye.pojo.User;
import com.yuye.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;
import org.apache.dubbo.rpc.cluster.support.FailbackCluster;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yuye
 * @Date: 2022/2/18 - 02 - 18 - 10:51
 * @Description: com.yuye.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /*@Autowired*/
    @Reference(timeout = 3000/*配置超时时间*/,retries = 2/*配置重试次数*/,loadbalance = RandomLoadBalance.NAME/*配置负载均衡机制*/,cluster = FailbackCluster.NAME/*配置集群重试机制*/,mock = "force:return null"/*配置服务降级*/) //dubbo远程注入
    private UserService userService;

    @GetMapping("/sayHello")
    //say hello
    public String sayHello(){
        return userService.sayHello();
    }

    @GetMapping("/{id}")
    //say hello
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

}
