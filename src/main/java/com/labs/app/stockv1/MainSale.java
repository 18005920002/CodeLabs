package com.labs.app.stockv1;

import org.testng.collections.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description: 100件商品，1000个用户同时参与购买，每个用户最多只能买2件。
 * 第1件-第20件商品，单价9.9元
 * 第21件-第50件商品，单价19.9元
 * 第51件-第100件商品，单价29.9元
 * 不允许超卖
 * <p>
 * 生产者：生产100个线程，
 * @Author: tanyun.zheng
 * @Date: 2019/8/22 09:07
 */
public class MainSale {

    public static void main(String[] args) throws Exception {

        //100个临界资源
        SaleStock saleStock = new SaleStock();
        //初始化1000个用户(任务)
        List<Customer> consumerList = Lists.newArrayList(1000);
        //随机选取用户
        ExecutorService cachedThreadPools = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 1000; i++) {
            Customer c = new Customer("Customer-" + i, saleStock);
            Future<Double> task = cachedThreadPools.submit(c);
            System.out.println(task.get());
        }
        cachedThreadPools.shutdown();

    }
}
