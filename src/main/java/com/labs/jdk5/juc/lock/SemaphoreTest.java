package com.labs.jdk5.juc.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量:控制同时可以访问的资源个数
 *
 * @author win10
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();

        final Semaphore sem = new Semaphore(3);//初始化信号量数量，表示可用资源数

        for (int i = 0; i < 20; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " ready to aquire, remainder:" + (3 - sem.availablePermits()));

                    try {
                        sem.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " use one, concurrent:" + sem.availablePermits());

                    try {
                        Thread.sleep(new Random().nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    sem.release();
                    System.out.println(Thread.currentThread().getName() + " release one, remainder:" + sem.availablePermits());

                }
            };
            pool.execute(r);
        }


    }


}
