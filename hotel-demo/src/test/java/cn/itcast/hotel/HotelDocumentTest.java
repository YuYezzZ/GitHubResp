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
import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FieldValueFactorFunctionBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    void testinit() {
        System.out.println(restHighLevelClient);
    }

    @Test
    void addHotelDocument() throws IOException {
        //??????id??????????????????
        Hotel hotel = hotelService.getById(61083L);
        //?????????????????????
        HotelDoc hotelDoc = new HotelDoc(hotel);
        //1.??????request??????
        IndexRequest request = new IndexRequest("hotel").id(hotelDoc.getId().toString());
        //2.????????????????????????DSL??????
        request.source(JSON.toJSONString(hotelDoc), XContentType.JSON);
        //3.????????????
        restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }

    @Test
    void getHotelDocument() throws IOException {
        //??????request
        GetRequest request = new GetRequest("hotel", "61083");
        //???????????????????????????
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        //????????????
        String sourceAsString = response.getSourceAsString();
        HotelDoc hotelDoc = JSON.parseObject(sourceAsString, HotelDoc.class);
        System.out.println(hotelDoc);
    }

    @Test
    void updateHotelDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("hotel", "61083");
        request.doc(
                "price", "952",
                "starName", "??????"
        );
        restHighLevelClient.update(request, RequestOptions.DEFAULT);
    }

    @Test
    void deleteHotelDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("hotel", "61083");
        restHighLevelClient.delete(request, RequestOptions.DEFAULT);
    }
    //?????????????????????????????????es???
    @Test
    void addBulkHotelDocument() throws IOException {
        //1.??????request??????
        BulkRequest request = new BulkRequest();
        //?????????????????????
        //??????id??????????????????
        List<Hotel> hotelList = hotelService.list();
        for (Hotel hotel : hotelList) {
            HotelDoc hotelDoc = new HotelDoc(hotel);
            //2.????????????????????????DSL??????
            request.add(new IndexRequest("hotel").id(hotelDoc.getId().toString()).source(JSON.toJSONString(hotelDoc), XContentType.JSON));
        }
        //3.????????????
        restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
    }

    @Test
    void searchMathAllHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.matchAllQuery());
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("????????????" + totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    @Test
    void searchMathHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.matchQuery("name", "??????"));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("????????????" + totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    @Test
    void searchTermHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.termQuery("brand", "??????"));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("????????????" + totalHits.value);
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
        System.out.println("????????????" + totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    @Test
    void searchGeoDistanceHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.geoDistanceQuery("location").distance("50km").point(31, 121));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("????????????" + totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    @Test
    void searchBoolHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must().add(QueryBuilders.matchQuery("all", "??????"));
        boolQuery.filter().add(QueryBuilders.rangeQuery("price").lte(400));
        boolQuery.filter().add(QueryBuilders.geoDistanceQuery("location").distance("10km").point(31.21, 121.5));
        request.source().query(boolQuery);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("????????????" + totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    @Test
    void searchPageHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.matchQuery("name", "??????"));
        request.source().from(1).size(5);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("????????????" + totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    @Test
    void searchHighlightHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().query(QueryBuilders.matchQuery("all", "??????"));
        request.source().from(1).size(5);
        request.source().highlighter(new HighlightBuilder().field("name").requireFieldMatch(false));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("????????????" + totalHits.value);
        SearchHit[] sourceHits = hits.getHits();

        for (SearchHit sourceHit : sourceHits) {
            Map<String, HighlightField> highlightFields = sourceHit.getHighlightFields();
            String sourceAsString = sourceHit.getSourceAsString();
            HotelDoc hotelDoc = JSON.parseObject(sourceAsString, HotelDoc.class);
            if (!CollectionUtils.isEmpty(highlightFields)) {
                HighlightField highlightField = highlightFields.get("name");
                if(highlightField!=null) {
                    String name = highlightField.getFragments()[0].toString();
                    hotelDoc.setName(name);
                }
            }
            System.out.println(hotelDoc);
        }
    }

    @Test
    void searchSuggestionDocument() throws IOException {
        //1.??????request
        SearchRequest request = new SearchRequest("hotel");
        //2.??????dsl??????
        request.source().suggest(new SuggestBuilder().addSuggestion("suggestions" ,SuggestBuilders.completionSuggestion("suggestion")
                .prefix("h")
                .skipDuplicates(true)
                .size(20)
        ));
        //3.????????????
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        //4.????????????
        Suggest suggest = response.getSuggest();
        CompletionSuggestion suggestions = suggest.getSuggestion("suggestions");
        List<CompletionSuggestion.Entry.Option> options = suggestions.getOptions();
        ArrayList<String> keyList = new ArrayList<>();
        for (CompletionSuggestion.Entry.Option option : options) {
            String key = option.getText().toString();
            keyList.add(key);
        }
        System.out.println(keyList);
    }

    @Test
    void searchFunctionScoreHotelDocument() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        FieldValueFactorFunctionBuilder fieldQuery = new FieldValueFactorFunctionBuilder("name");
        fieldQuery.setWeight(10);
        FunctionScoreQueryBuilder functionQuery = QueryBuilders.functionScoreQuery(QueryBuilders.matchQuery("all", "??????"), fieldQuery);
        functionQuery.boostMode(CombineFunction.SUM);
        request.source().query(functionQuery);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("????????????" + totalHits.value);
        SearchHit[] sourceHits = hits.getHits();
        for (SearchHit sourceHit : sourceHits) {
            String sourceAsString = sourceHit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    @BeforeEach
        //index??????
    void setUp() {
        this.restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.127.129:9200")
        ));
    }

    @AfterEach
    void tearDown() throws IOException {
        this.restHighLevelClient.close();
    }
}
