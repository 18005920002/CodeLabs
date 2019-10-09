package com.labs.app.concurrent;

import org.testng.collections.Lists;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * 100件商品，1000个用户同时参与购买，每个用户最多只能买2件。
 * 第1件-第20件商品，单价9.9元
 * 第21件-第50件商品，单价19.9元
 * 第51件-第100件商品，单价29.9元
 * 不允许超卖
 *
 * @Author: tanyun.zheng
 * @Date: 2019/8/22 09:07
 */
public class MainSale {

    public static void main(String[] args) throws Exception{

        //100个临界资源
        final Stock stock = new Stock(100);
        final Map<Integer,Integer> cache = new ConcurrentHashMap<>();

        System.out.println("当前库存："+stock.getStock());

        int corePoolSize = 10;
        int maximumPoolSize = Integer.MAX_VALUE;
        long keepAliveTime = 100;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = null;
        ThreadFactory threadFactory;

        //初始化1000个用户
        List<Customer> consumerList = Lists.newArrayList(1000);
        for(int i=0;i<1000;i++){
            Customer c = new Customer(i);
            consumerList.add(c);
        }

        //随机选取用户
        ExecutorService cachedThreadPools = Executors.newCachedThreadPool();
        final Lock lock = new ReentrantLock();
        while (true){
            //随机选择一个用户
            // 0 <= d < 1
            Double d = Math.random();
            final Customer c = consumerList.get((int)(d*100));

            final Integer limit = null==cache.get(c.getId())?0:cache.get(c.getId());
            if(null!=limit && limit.intValue()>=2){
                System.out.println(c.getName()+" 已经购买2件，不能再购买");
                continue;
            }

            Callable r = new Callable() {
                @Override
                public Object call() throws Exception {
                    Boolean soldOut = false;
                    try {
                        lock.lock();
                        stock.subStock(c.getId());
                        System.out.println("stock remain:"+stock.getStock());
                        cache.put(c.getId(),limit+1);
                        if(stock.getStock().intValue()==0){
                            soldOut=true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                    return soldOut;
                }

            };
            Future f = cachedThreadPools.submit(r);
            if((Boolean)f.get()==Boolean.TRUE){
                break;
            }
        }
    }
}
