import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: yuye
 * @Date: 2022/2/22 - 02 - 22 - 14:38
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class CuratorLockTest {
    private CuratorFramework client;
    //建立链接
    @Before
    public void testConnect(){
        //链接服务器
        //1.服务器地址
        String host = "192.168.127.129:2181";
        //2.重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000,10);
        //3.用newClient创建链接
        //CuratorFramework client = CuratorFrameworkFactory.newClient(host, 60 * 1000, 15 * 1000, retryPolicy);
        //3.用builder创建链接
        client = CuratorFrameworkFactory.builder()
                .connectString(host)
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryPolicy)
                .namespace("yuye").build();
        //4.开启链接
        client.start();
    }

    @Test
    //分布式锁
    public void testLock(){
        int tocket = 10;
    }
    @After
    //释放资源
    public void close(){
        client.close();
    }
}
