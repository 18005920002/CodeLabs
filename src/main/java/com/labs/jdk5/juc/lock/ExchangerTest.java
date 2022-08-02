package com.labs.jdk5.juc.lock;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final Exchanger<String> exchanger = new Exchanger<String>();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String data = "xxx";
                    System.out.println(Thread.currentThread().getName() +
                            " is ready to exchange: " + data);
                    Thread.sleep(new Random().nextInt(1000));
                    data = exchanger.exchange(data, 10, TimeUnit.SECONDS);
                    System.out.println(Thread.currentThread().getName() + " DATA HAS BEEN EXCHANGE TO " + data);
                } catch (Exception e) {

                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String data = "TTT";
                    System.out.println(Thread.currentThread().getName() +
                            " is ready to exchange: " + data);
                    Thread.sleep(new Random().nextInt(1000));
                    data = exchanger.exchange(data, 10, TimeUnit.SECONDS);
                    System.out.println(Thread.currentThread().getName() + " DATA HAS BEEN EXCHANGE TO " + data);
                } catch (Exception e) {

                }
            }
        });
    }
}
