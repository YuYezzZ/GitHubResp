package cn.itcast.user.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: yuye
 * @Date: 2022/1/23 - 01 - 23 - 17:16
 * @Description: cn.itcast.user.pojo
 * @version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class MyDateFormat {
    private String dateformat;
    private String name;
}
