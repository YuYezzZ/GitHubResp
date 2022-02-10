package cn.itcast.mq.listenner;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @Auther: yuye
 * @Date: 2022/2/9 - 02 - 09 - 22:41
 * @Description: cn.itcast.mq.listenner
 * @version: 1.0
 */
@Component
public class RabbitMQListenner {
    /*@RabbitListener(queues = "simple.queue")
    //springboot集成rabbitMQ
    public void receiveSimpleQueueMessages(String msg){
        System.out.println("接收到信息："+msg);
    }*/
    @RabbitListener(queues = "simple.queue")
    //springboot集成rabbitMQ
    public void receiveWorkQueueMessages1(String msg) throws InterruptedException {
        System.err.println("接收到信息1："+msg+ "======="+LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    //springboot集成rabbitMQ
    public void receiveWorkQueueMessages2(String msg) throws InterruptedException {
        System.out.println("接收到信息2："+msg+"======="+ LocalTime.now());
        Thread.sleep(100);
    }
    @RabbitListener(queues = "fanout.queue1")
    //springboot集成rabbitMQ
    public void receiveFanoutMessages1(String msg) throws InterruptedException {
        System.out.println("接收到信息1："+msg+"======="+ LocalTime.now());
    }
    @RabbitListener(queues = "fanout.queue2")
    //springboot集成rabbitMQ
    public void receiveFanoutMessages2(String msg) throws InterruptedException {
        System.out.println("接收到信息2："+msg+"======="+ LocalTime.now());
    }
}
