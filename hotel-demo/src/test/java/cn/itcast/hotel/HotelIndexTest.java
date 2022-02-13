package cn.itcast.hotel;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static cn.itcast.hotel.constants.HotelConstants.MAPPING_TEMPLATE;

/**
 * @Auther: yuye
 * @Date: 2022/2/10 - 02 - 10 - 14:56
 * @Description: cn.itcast.hotel
 * @version: 1.0
 */

public class  HotelIndexTest {
    private RestHighLevelClient restHighLevelClient;

    @Test
    void testinit(){
        System.out.println(restHighLevelClient);
    }
    @Test
    void createHotelIndex() throws IOException {
        //1.创建request对象
        CreateIndexRequest request = new CreateIndexRequest("hotel");
        //2.准备请求的参数：DSL语句
        request.source(MAPPING_TEMPLATE, XContentType.JSON);
        //3.发送请求
        restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }
    @Test
    void deleteHotelIndex() throws IOException {
        //1.创建删除request对象
        DeleteIndexRequest request = new DeleteIndexRequest("hotel");
        //2.发送请求
        restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
    }
    @Test
    void getHotelIndex() throws IOException {
        //1.创建删除request对象
        GetIndexRequest request = new GetIndexRequest("hotel");
        //2.发送请求
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        //3.判断是否存在
        System.out.println(exists?"存在":"不存在");
    }

    @BeforeEach
    //index测试
    void setUp(){
        this.restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.127.129:9200")
        ));
    }
    @AfterEach
    void tearDown() throws IOException {
        this.restHighLevelClient.close();
    }
}
