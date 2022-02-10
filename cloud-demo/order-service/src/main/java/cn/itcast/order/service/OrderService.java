package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /*@Autowired
    private RestTemplate restTemplate;*/
    @Autowired
    private UserClient userClient;
    public Order queryOrderById(Long orderId) {

        //Feign方法
        //1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.根据订单的userId查询user信息
        User user = userClient.getUserById(order.getUserId());
        //3.将user对象设置到订单中
        order.setUser(user);
        //4.返回
       /*
        //restTemplate方法
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.根据订单的userId查询user信息
        //String url = "http://localhost:8081/user/"+order.getUserId();
        //eureka注册后格式
        String url = "http://userservice/user/"+order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        //3.将user对象设置到订单中
        order.setUser(user);
        // 4.返回*/
        return order;
    }
}
