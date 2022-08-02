package com.labs.concurrent.pool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tanyun.zheng
 * @date 2020/12/15 9:24
 */
public class PoolTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 20; i++) {
            pool.submit(new PrintTask());
        }
        System.out.println("end");
    }

    static class PrintTask implements Runnable {
        public PrintTask() {
        }

        @Override
        public void run() {
            try {
                System.out.println("xxxxxx");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + "执行中");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
