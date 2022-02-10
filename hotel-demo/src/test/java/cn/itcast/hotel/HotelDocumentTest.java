package cn.itcast.hotel;

import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.service.impl.HotelService;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/2/10 - 02 - 10 - 14:56
 * @Description: cn.itcast.hotel
 * @version: 1.0
 */
@SpringBootTest
public class HotelDocumentTest {
    @Autowired
    private HotelService hotelService;

    private RestHighLevelClient restHighLevelClient;

    @Test
    void testinit(){
        System.out.println(restHighLevelClient);
    }
    @Test
    void addHotelDocument() throws IOException {
        //根据id查询酒店数据
        Hotel hotel = hotelService.getById(61083L);
        //转换为文档类型
        HotelDoc hotelDoc = new HotelDoc(hotel);
        //1.创建request对象
        IndexRequest request = new IndexRequest("hotel").id(hotelDoc.getId().toString());
        //2.准备请求的参数：DSL语句
        request.source(JSON.toJSONString(hotelDoc), XContentType.JSON);
        //3.发送请求
        restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }
    @Test
    void getHotelDocument() throws IOException {
        //准备request
        GetRequest request = new GetRequest("hotel", "61083");
        //发送请求，获取响应
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        //解析响应
        String sourceAsString = response.getSourceAsString();
        HotelDoc hotelDoc = JSON.parseObject(sourceAsString, HotelDoc.class);
        System.out.println(hotelDoc);
    }
    @Test
    void updateHotelDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("hotel","61083");
        request.doc(
                "price","952",
                "starName","四钻"
        );
        restHighLevelClient.update(request, RequestOptions.DEFAULT);
    }
    @Test
    void deleteHotelDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("hotel","61083");
        restHighLevelClient.delete(request, RequestOptions.DEFAULT);
    }

    @Test
    void addBulkHotelDocument() throws IOException {
        //1.创建request对象
        BulkRequest request = new BulkRequest();
        //转换为文档类型
        //根据id查询酒店数据
        List<Hotel> hotelList = hotelService.list();
        for (Hotel hotel : hotelList) {
            HotelDoc hotelDoc = new HotelDoc(hotel);
            //2.准备请求的参数：DSL语句
            request.add(new IndexRequest("hotel").id(hotelDoc.getId().toString()).source(JSON.toJSONString(hotelDoc),XContentType.JSON));
        }
        //3.发送请求
        restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
    }
    @Test
    void searchMathAllHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.matchAllQuery());
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("总条数："+totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }
    @Test
    void searchMathHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.matchQuery("name","如家"));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("总条数："+totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }
    @Test
    void searchTermHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.termQuery("brand","如家"));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("总条数："+totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }
    @Test
    void searchRangeHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.rangeQuery("price").lte(240));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("总条数："+totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }
    @Test
    void searchGeoDistanceHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.geoDistanceQuery("location").distance("50km").point(31,121));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("总条数："+totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }
    @Test
    void searchFunctionScoreHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        FunctionScoreQueryBuilder functionQuery = QueryBuilders.functionScoreQuery(QueryBuilders.matchQuery("name","如家"));
        request.source().query(functionQuery);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("总条数："+totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
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
