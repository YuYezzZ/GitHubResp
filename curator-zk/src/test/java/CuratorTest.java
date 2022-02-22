import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/2/22 - 02 - 22 - 14:38
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class CuratorTest {
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
    //基本创建
    public void testCreate() throws Exception {
        String path = client.create().forPath("/app2","hehe".getBytes(StandardCharsets.UTF_8));
        System.out.println(path);
    }
    @Test
    //创建临时节点
    public void testCreateEPHEMERAL() throws Exception {
        String path = client.create().withMode(CreateMode.EPHEMERAL/*设置节点类型*/).forPath("/app2","hehe".getBytes(StandardCharsets.UTF_8));
        System.out.println(path);
    }
    @Test
    //创建多级节点
    public void testCreateParents() throws Exception {
        String path = client.create().creatingParentsIfNeeded().forPath("/app4/p1","hehe".getBytes(StandardCharsets.UTF_8));
        System.out.println(path);
    }

    @Test
    //查询节点数据
    public void testGet() throws Exception {
        byte[] bytes = client.getData().forPath("/app1");
        System.out.println(new String(bytes));
    }
    @Test
    //查询子节点
    public void testGetChildren() throws Exception {
        List<String> strings = client.getChildren().forPath("/app4");
        System.out.println(strings);
    }
    @Test
    //查询节点状态信息
    public void testGetStatus() throws Exception {
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        System.out.println(stat);
    }

    @Test
    //修改节点数据
    public void testSet() throws Exception {
        Stat stat = client.setData().forPath("/app1", "yuye".getBytes(StandardCharsets.UTF_8));
        System.out.println(stat);
    }
    //根据版本修改节点数据
    public void testSetWithVersion() throws Exception {
        int version = 0 ;
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        version = stat.getVersion();
        client.setData().withVersion(version).forPath("/app1", "yuye".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    //删除单个节点
    public void testDelete() throws Exception {
        client.delete().forPath("/app1");
    }
    @Test
    //删除含子节点的节点
    public void testDeleteChildren() throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath("/app4");
    }
    @Test
    //必须删除成功,防止网络波动,本质上就是重试
    public void testDeleteGuaranteed() throws Exception {
        client.delete().guaranteed().forPath("/app2");
    }
    @Test
    //删除后回调
    public void testDeleteBackground() throws Exception {

        client.delete().guaranteed().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println("我被删除了");
            }
        }).forPath("/app4/p1/p2");
    }
    @After
    //释放资源
    public void close(){
        client.close();
    }
}
