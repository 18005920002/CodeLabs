package com.labs.jdk5.juc.lock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is waiting for ORDER");
                        cdOrder.await();
                        System.out.println(Thread.currentThread().getName() + " has accepted ORDER");
                        Thread.sleep(new Random().nextInt(2000));
                        System.out.println(Thread.currentThread().getName() + " Anser the result");
                        cdAnswer.countDown();
                    } catch (Exception e) {

                    }
                }
            };
            pool.execute(r);
        }

        try {
            Thread.sleep(new Random().nextInt(2000));
            System.out.println(Thread.currentThread().getName() + " will send Order");

            cdOrder.countDown();
            System.out.println(Thread.currentThread().getName() + " has send order,waiting for result..");

            cdAnswer.await();
            System.out.println(Thread.currentThread().getName() + " recived all result");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
