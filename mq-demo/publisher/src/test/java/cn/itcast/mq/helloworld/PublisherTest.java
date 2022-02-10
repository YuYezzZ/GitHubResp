package cn.itcast.mq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        // 1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.设置连接参数，分别是：主机名、端口号、vhost、用户名、密码
        factory.setHost("192.168.127.129");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("itcast");
        factory.setPassword("123321");
        // 1.2.建立连接
        Connection connection = factory.newConnection();

        // 2.创建通道Channel
        Channel channel = connection.createChannel();

        // 3.创建队列
        String queueName = "simple.queue";
        channel.queueDeclare(queueName, false, false, false, null);

        // 4.发送消息
        String message = "hello, rabbitmq!";
        channel.basicPublish("", queueName, null, message.getBytes());
        System.out.println("发送消息成功：【" + message + "】");

        // 5.关闭通道和连接
        channel.close();
        connection.close();

    }
    @Test
    public void testSendMessage2(){
        String queueName = "simple.queue";
        String msg = "hello,spring.amqp";
        rabbitTemplate.convertAndSend(queueName,msg);
    }
    @Test
    public void testSendWorkQueueMessage(){
        String queueName = "simple.queue";
        String msg = "hello,spring.amqp";
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queueName,msg+"________"+i);
        }
    }
    @Test
    public void testSendFanoutMessage(){
        String exchangeName = "itcast.fanout";
        String msg = "hello,fanout.message";
        rabbitTemplate.convertAndSend(exchangeName,"",msg);
    }
}
