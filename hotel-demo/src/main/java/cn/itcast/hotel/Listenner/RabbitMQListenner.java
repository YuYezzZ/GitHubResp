package cn.itcast.hotel.Listenner;

import cn.itcast.hotel.constants.RabbitMqEnum;
import cn.itcast.hotel.service.impl.HotelService;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import static cn.itcast.hotel.constants.RabbitMqEnum.*;

/**
 * @Auther: yuye
 * @Date: 2022/2/12 - 02 - 12 - 17:13
 * @Description: cn.itcast.hotel.Listenner
 * @version: 1.0
 */
@Component
public class RabbitMQListenner {
    @Autowired
    private HotelService hotelService;
    @RabbitListener(@QueueBinding(value = QUEUE_INSERT_NAME,exchange = EXCHANGE_NAME,key = ROUTING_INSERT_KEY))
    void insertHotelDocument(Long id){
        //1.根据id查询数据

        //2.准备request
        //3.准备dsl语句
        //4.发送请求
    }
}
