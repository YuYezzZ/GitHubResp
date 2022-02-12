package cn.itcast.hotel.service.impl;

import cn.itcast.hotel.mapper.HotelMapper;
import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.pojo.PageResult;
import cn.itcast.hotel.pojo.RequestParams;
import cn.itcast.hotel.service.IHotelService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Override
    public PageResult search(RequestParams requestParams) throws IOException {

        System.out.println(requestParams);
        SearchRequest searchRequest = new SearchRequest("hotel");
        BoolQueryBuilder boolQueryBuilder = getBoolQueryBuilder(requestParams);
        searchRequest.source().query(boolQueryBuilder);
        int page = requestParams.getPage();
        int size = requestParams.getSize();
        searchRequest.source().from((page-1)*size);
        searchRequest.source().size(size);
        String sort = requestParams.getSortBy().toString();
        if("price".equals(sort)){
            searchRequest.source().sort(sort);
        }
        if("score".equals(sort)) {
            searchRequest.source().sort(sort, SortOrder.DESC);
        }
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        return  getPageResult(response);
    }

    @Override
    public Map<String, List<String>> searchAgg(RequestParams requestParams) throws IOException {
        //1.准备request
        SearchRequest searchRequest = new SearchRequest("hotel");
        BoolQueryBuilder boolQueryBuilder = getBoolQueryBuilder(requestParams);
        searchRequest.source().query(boolQueryBuilder);
        int page = requestParams.getPage();
        int size = requestParams.getSize();
        searchRequest.source().from((page-1)*size);
        searchRequest.source().size(size);
        String sort = requestParams.getSortBy().toString();
        if("price".equals(sort)){
            searchRequest.source().sort(sort);
        }
        if("score".equals(sort)) {
            searchRequest.source().sort(sort, SortOrder.DESC);
        }

        searchRequest.source().size(0);
        //2.准备DSL语句
        searchRequest.source().aggregation(AggregationBuilders
                .terms("brandAggs")
                .field("brand")
                .order(BucketOrder.key(false))
                .size(100)
        );
        searchRequest.source().aggregation(AggregationBuilders
                .terms("cityAggs")
                .field("city")
                .order(BucketOrder.key(false))
                .size(100)
        );
        searchRequest.source().aggregation(AggregationBuilders
                .terms("starNameAggs")
                .field("starName")
                .order(BucketOrder.key(false))
                .size(100)
        );
        //3.发送请求
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        HashMap<String, List<String>> map = new HashMap<>();

        Aggregations aggregations = response.getAggregations();
        ArrayList<String> brands = getAggsList(aggregations,"brandAggs");
        map.put("brand",brands);
        ArrayList<String> citys = getAggsList(aggregations,"cityAggs");
        map.put("city",citys);
        ArrayList<String> starNames = getAggsList(aggregations,"starNameAggs");
        map.put("starName",starNames);
        System.out.println(map);
        return map;
    }

    @Override
    public List<String> suggestion(String prefix) {
        ArrayList<String> keyList = null;
        try {
            //准备request
            SearchRequest request = new SearchRequest("hotel");
            //准备dsl语句
            request.source().suggest(new SuggestBuilder().addSuggestion("suggestions", SuggestBuilders.completionSuggestion("suggestion")
                    .prefix(prefix)
                    .skipDuplicates(true)
                    .size(20)
            ));
            //发送请求
            SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            //解析
            Suggest suggest = response.getSuggest();
            keyList = new ArrayList<>();
            CompletionSuggestion suggestions = suggest.getSuggestion("suggestions");
            List<CompletionSuggestion.Entry.Option> options = suggestions.getOptions();
            for (CompletionSuggestion.Entry.Option option : options) {
                String key = option.getText().toString();
                keyList.add(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keyList;
    }

    private ArrayList<String> getAggsList(Aggregations aggregations,String aggsName) {
        Terms brandAggTerms = aggregations.get(aggsName);
        List<? extends Terms.Bucket> buckets = brandAggTerms.getBuckets();
        ArrayList<String> brands = new ArrayList<>();
        for (Terms.Bucket bucket : buckets) {
            String brand = bucket.getKey().toString();
            brands.add(brand);
        }
        return brands;
    }

    private BoolQueryBuilder getBoolQueryBuilder(RequestParams requestParams) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        String key = requestParams.getKey();
        String city = requestParams.getCity();
        String starName = requestParams.getStarName();
        String brand = requestParams.getBrand();
        Integer minPrice = requestParams.getMinPrice();
        Integer maxPrice = requestParams.getMaxPrice();
        if (key == null || "".equals(key) ){
            boolQueryBuilder.must().add(QueryBuilders.matchAllQuery());
        }else {
            boolQueryBuilder.must().add(QueryBuilders.matchQuery("all",key));
        }
        if (city != null && !("".equals(city)) ){
            boolQueryBuilder.filter().add(QueryBuilders.termQuery("city",city));
        }
        if (starName != null && !("".equals(starName)) ){
            boolQueryBuilder.filter().add(QueryBuilders.termQuery("starName",starName));
        }
        if (brand != null && !("".equals(brand)) ){
            boolQueryBuilder.filter().add(QueryBuilders.termQuery("brand",brand));
        }
        if (minPrice != null && maxPrice != null ){
            boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("price").gte(minPrice).lte(maxPrice));
        }
        return boolQueryBuilder;
    }

    private PageResult getPageResult(SearchResponse response) {
        TotalHits totalHits = response.getHits().getTotalHits();
        SearchHits hits = response.getHits();
        ArrayList<HotelDoc> hotels= new ArrayList<>();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            HotelDoc hotelDoc = JSON.parseObject(sourceAsString, HotelDoc.class);
            hotels.add(hotelDoc);
        }
        Long total = totalHits.value;
        PageResult pageResult = new PageResult(total, hotels);
        return pageResult;
    }
}
