package com.cmy.zookeeper;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZKConnection {  
    /** 
     * server列表, 以逗号分割 
     */  
    protected String hosts = "127.0.0.1:12181";  
    /** 
     * 连接的超时时间, 毫秒 
     */  
    private static final int SESSION_TIMEOUT = 5000;  
    private CountDownLatch connectedSignal = new CountDownLatch(1);  
    protected ZooKeeper zk;  
  
    /** 
     * 连接zookeeper server 
     */  
    public void connect() throws Exception {  
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, new ConnWatcher());  
        // 等待连接完成  
//        connectedSignal.await();  
    }  
    
    public void create() throws Exception{
    	zk.create("/test/hehe2", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);  

    }
  
    public class ConnWatcher implements Watcher {  
        public void process(WatchedEvent event) {  
            // 连接建立, 回调process接口时, 其event.getState()为KeeperState.SyncConnected  
            if (event.getState() == KeeperState.SyncConnected) {  
                // 放开闸门, wait在connect方法上的线程将被唤醒  
                connectedSignal.countDown();  
            }  
        }  
    }  
    
    
}  