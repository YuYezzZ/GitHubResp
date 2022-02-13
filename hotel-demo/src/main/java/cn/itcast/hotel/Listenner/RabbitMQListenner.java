package cn.itcast.hotel.Listenner;

import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.service.impl.HotelService;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("hotel.insert.queue"),
            exchange = @Exchange(value = "hotel.topic", type = ExchangeTypes.TOPIC),
            key = "hotel.document.insert"))
    void insertHotelDocument(Long id){
        try {
            //1.根据id查询数据
            Hotel hotel = hotelService.getById(id);
            HotelDoc hotelDoc = new HotelDoc(hotel);
            //2.准备request
            IndexRequest request = new IndexRequest("hotel");
            //3.准备dsl语句
            request.source(JSON.toJSONString(hotelDoc), XContentType.JSON).id(id.toString());
            //4.发送请求
            restHighLevelClient.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("hotel.delete.queue"),
            exchange = @Exchange(value = "hotel.topic", type = ExchangeTypes.TOPIC),
            key = "hotel.document.delete"))
    void deleteHotelDocument(Long id){
        try {
            //1.准备request
            DeleteRequest request = new DeleteRequest("hotel").id(id.toString());
            //2.发送请求
            restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
