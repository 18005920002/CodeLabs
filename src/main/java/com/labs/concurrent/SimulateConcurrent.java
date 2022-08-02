package com.labs.concurrent;

import com.sun.deploy.security.BadCertificateDialog;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 模拟并发框架
 * @Author: tanyun.zheng
 * @Date: 2020/8/27
 */
public class SimulateConcurrent {
    //任务数
    private static int taskCount = 10000;
    //并发度 通过信号量控制
    private static int concurrentCount = 20;
    //共享数据
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(taskCount);
        Semaphore semaphore = new Semaphore(concurrentCount);
        for (int i = 0; i < taskCount; i++) {
            semaphore.acquire();
            pool.submit(() -> {
                add();
            });
            semaphore.release();
            countDownLatch.countDown();
        }
        countDownLatch.await();
        pool.shutdown();
        System.out.println(count.get());
    }

    public static void add() {
        count.incrementAndGet();
    }
}
