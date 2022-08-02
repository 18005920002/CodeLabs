package com.labs.app.stockv1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/15
 */
public class SaleStock {

    private Integer stockCount = 100;

    public SaleStock() {

    }

    public Integer getStock() {
        return this.stockCount;
    }

    public Double buy(String customerId) throws SoldOutException {
        Double price = 29.9;
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if (stockCount > 0) {
                stockCount--;

                if (stockCount > 60) {
                    price = 19.9;
                }
                if (stockCount > 90) {
                    price = 9.9;
                }
                System.out.println(customerId + "buy@:" + price + ", remain" + stockCount);
            } else {
                price = 0.0;
                System.out.println("Sold Out.");
            }
        } finally {
            lock.unlock();
        }
        return price;
    }
}
