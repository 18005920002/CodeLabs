package com.labs.jdk5.juc.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final CyclicBarrier cb = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                        System.out.println(Thread.currentThread().getName()
                                + "即将到达集合点1，当前已有" + cb.getNumberWaiting());
                        cb.await();

                        Thread.sleep(new Random().nextInt(2000));
                        System.out.println(Thread.currentThread().getName()
                                + "即将到达集合点2，当前已有" + cb.getNumberWaiting());
                        cb.await();

                        Thread.sleep(new Random().nextInt(1000));
                        System.out.println(Thread.currentThread().getName()
                                + "即将到达集合点3，当前已有" + cb.getNumberWaiting());
                        cb.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            //new Thread(r).start();
            pool.execute(r);
        }
    }
}
