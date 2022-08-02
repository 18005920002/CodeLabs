package com.labs.java8.juc.pool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/20
 */
public class PoolTest {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,
                15,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue(50),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("服务繁忙，请稍后重试...");
                    }
                }
        );
        int i = 500;
        System.out.println("==========\n" + pool.getQueue().remainingCapacity());
        while (i-- > 0) {
            Thread.sleep(new Random().nextInt(50));
            pool.submit(new CountTask(pool));
        }

        int j = 10;
        while (j-- > 0) {
            Thread.sleep(1000);
            System.out.println(pool.getLargestPoolSize() + ":"
                    + pool.getCorePoolSize() + ":"
                    + pool.getPoolSize() + ":"
                    + pool.getTaskCount() + ":"
                    + pool.getActiveCount() + ":"
                    + pool.getQueue().remainingCapacity() + ":" + ":" + ":" + ":");
        }
        pool.shutdown();

    }


}

class CountTask implements Callable<Integer> {
    private ThreadPoolExecutor curr;

    public CountTask(ThreadPoolExecutor curr) {
        this.curr = curr;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(new Random().nextInt(1000));
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + ":" + sum);
        System.out.println(curr.getLargestPoolSize() + ":"
                + curr.getTaskCount() + ":"
                + curr.getActiveCount() + ":"
                + curr.getQueue().remainingCapacity() + ":" + ":" + ":" + ":");
        return sum;
    }
}
