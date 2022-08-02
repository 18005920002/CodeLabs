package com.labs.app.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 库存信息
 * @Author: tanyun.zheng
 * @Date: 2019/8/22 12:09
 */
public class Stock {

    public Stock() {
    }

    public Stock(Integer stock) {
        this.stock = stock;
    }

    private Integer stock;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean subStock(Integer userId, Lock lock) {

        try {
            lock.lock();
            if (stock == 0) {
                System.out.println("已售罄");
                return Boolean.FALSE;
            }
            --stock;
            Double price = 29.9;

            if (stock > 50) {
                price = 19.9;
            }

            if (stock > 80) {
                price = 9.9;
            }
            System.out.println("User-" + userId + " buy @ price: " + price);
        } finally {
            lock.unlock();
        }

        return Boolean.TRUE;
    }

}
