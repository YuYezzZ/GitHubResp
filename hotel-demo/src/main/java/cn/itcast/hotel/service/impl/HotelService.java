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
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

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
