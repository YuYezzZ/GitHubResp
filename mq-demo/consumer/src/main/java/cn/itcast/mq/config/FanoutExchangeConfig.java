package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: yuye
 * @Date: 2022/2/10 - 02 - 10 - 22:25
 * @Description: cn.itcast.mq.config
 * @version: 1.0
 */
@Configuration
public class FanoutExchangeConfig {
    //创建fanout交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("itcast.fanout");
    }
    //创建fanout.queue1消息队列
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanout.queue1");
    }
    //将fanout.queue1消息队列绑定到fanout交换机上
    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }
    //创建fanout.queue2消息队列
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanout.queue2");
    }
    //将fanout.queue2消息队列绑定到fanout交换机上
    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
