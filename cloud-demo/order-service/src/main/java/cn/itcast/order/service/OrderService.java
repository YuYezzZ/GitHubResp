package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.根据订单的userId查询user信息
        //String url = "http://localhost:8081/user/"+order.getUserId();
        //eureka注册后格式
        String url = "http://userservice/user/"+order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        //3.将user对象设置到订单中
        order.setUser(user);
        // 4.返回
        return order;
    }
}
