package com.labs.java8.juc;

import com.labs.app.concurrent.Stock;
import lombok.SneakyThrows;
import org.testng.collections.Maps;

import java.util.Random;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/21
 */
public class ConcurrentAdjust {
    public static void main(String[] args) throws Exception {
        StockContext context = new StockContext();

        context.goodsStock = Maps.newHashMap();
        for (int i = 0; i < 100; i++) {
            ConcurrentAdjust.putValue(context);
        }

    }

    public static void putValue(final StockContext context) throws Exception {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Double d = context.goodsStock.get(123L);
                if (null == d) {
                    d = 0.0;
                }
                context.goodsStock.put(123L, d + 5.0);
                System.out.println(context.goodsStock.get(123L));
                Thread.sleep(Math.round(Math.random() * 1000));
            }
        }).start();
    }

}
