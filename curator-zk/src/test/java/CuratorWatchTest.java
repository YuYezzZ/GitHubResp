import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
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
public class CuratorWatchTest {
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
    //演示NodeCache
    public void testNodeCache() throws Exception {
        //1.创建NodeCache对象
        final NodeCache nodeCache = new NodeCache(client, "/app4/p1", false);
        //2.注册监听
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点变化了！");
                byte[] data = nodeCache.getCurrentData().getData();
                System.out.println(new String(data));
            }
        });
        //3.开启监听,如果设置为true，则开启监听时加载缓冲数据
        nodeCache.start(true);

        while(true){}
    }

    @Test
    //演示PathChildrenCache
    public void testPathChildrenCache() throws Exception {
        //1.创建PathChildrenCache对象
        final PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app4", true);
        //2.注册监听
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("节点变化了！");
                System.out.println(pathChildrenCacheEvent);
                //监听子节点的数据变更，并拿到变更的数据
                PathChildrenCacheEvent.Type type = pathChildrenCacheEvent.getType();
                if(PathChildrenCacheEvent.Type.CHILD_UPDATED.equals(type)){
                    byte[] data = pathChildrenCacheEvent.getData().getData();
                    System.out.println(data);
                    System.out.println("数据变了");
                    System.out.println(new String(data));
                }
            }
        });
        //3.开启监听,如果设置为true，则开启监听时加载缓冲数据
        pathChildrenCache.start();

        while(true){}
    }
    @Test
    //演示TreeCache
    public void testTreeCache() throws Exception {
        //1.创建NodeCache对象
        final TreeCache treeCache = new TreeCache(client, "/");
        //2.注册监听
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println("节点变化了！");
                System.out.println(treeCacheEvent);

                    byte[] data = treeCacheEvent.getData().getData();
                    System.out.println(data);
                    System.out.println("数据变了");
                    System.out.println(new String(data));
            }
        });
        //3.开启监听,如果设置为true，则开启监听时加载缓冲数据
        treeCache.start();

        while(true){}
    }

    @After
    //释放资源
    public void close(){
        client.close();
    }
}
