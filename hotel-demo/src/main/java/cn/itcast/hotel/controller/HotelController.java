package cn.itcast.hotel.controller;

import cn.itcast.hotel.pojo.PageResult;
import cn.itcast.hotel.pojo.RequestParams;
import cn.itcast.hotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yuye
 * @Date: 2022/2/11 - 02 - 11 - 10:32
 * @Description: cn.itcast.hotel.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private IHotelService hotelService;

    @PostMapping("/list")
    public PageResult search(@RequestBody RequestParams requestParams) throws IOException {
        return  hotelService.search(requestParams);
    }
    @PostMapping("/filters")
    public Map<String, List<String>> searchAgg(@RequestBody RequestParams requestParams) throws IOException {
        return hotelService.searchAgg(requestParams);
    }
    @GetMapping("/suggestion")
    public List<String> suggestion(@RequestParam("key") String prefix){
        return hotelService.suggestion(prefix);
    }
}
