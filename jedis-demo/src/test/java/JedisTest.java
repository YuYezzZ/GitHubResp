import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @Auther: yuye
 * @Date: 2022/2/15 - 02 - 15 - 10:00
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class JedisTest {
    @Test
    //jedis入门测试
    public void testJedis(){
        //1.链接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //2.操作redis
        //jedis.set("name","yuye");
        //jedis.lpush("a","2","3","4");
        jedis.hset("hash","name","zs");
        jedis.hset("hash","age","20");
        //3.关闭链接
        jedis.close();
    }
    @Test
    //jedis查询
    public void getJedis(){
        //1.链接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //2.操作redis
        //String name = jedis.get("name");
        //List<String> a = jedis.lrange("a", 0, -1);
        Map<String, String> hash = jedis.hgetAll("hash");
        System.out.println(hash);
        //3.关闭链接
        jedis.close();
    }
}
