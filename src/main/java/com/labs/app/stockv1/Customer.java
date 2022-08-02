package com.labs.app.stockv1;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/15
 */
public class Customer implements Callable<Double> {

    private SaleStock saleStock;
    private String customerId;
    private Double amount = 0d;

    public Customer(String customerId, SaleStock saleStock) {
        this.saleStock = saleStock;
        this.customerId = customerId;
    }

    @Override
    public Double call() throws Exception {
        int total = 0;
        while (true) {
            Thread.sleep(new Random().nextInt(100));
            if (0 == saleStock.getStock()) {
                System.out.println("不能超过两件");
                break;
            }
            amount += saleStock.buy(customerId);
            total++;
            System.out.println(Thread.currentThread().getName() + ":" + customerId + " buys " + total);
            if (total == 2) {
                break;
            }
        }

        System.out.println(customerId + " should pay:" + amount);
        return amount;
    }
}
