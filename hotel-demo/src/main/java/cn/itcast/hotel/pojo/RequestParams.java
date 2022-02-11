package cn.itcast.hotel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: yuye
 * @Date: 2022/2/11 - 02 - 11 - 10:27
 * @Description: cn.itcast.hotel.pojo
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestParams {
    private String key;
    private Integer page;
    private Integer size;
    private String sortBy;
    private String city;
    private String starName;
    private String brand;
    private Integer minPrice;
    private Integer maxPrice;
}
