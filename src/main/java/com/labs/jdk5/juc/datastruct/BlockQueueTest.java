package com.labs.jdk5.juc.datastruct;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 * 先进先出，
 * 有固定的，队列满了后就阻塞（阻塞队列）或报错（非阻塞队列）
 *
 * @author win10
 */
public class BlockQueueTest {
    public static void main(String[] args) {
        /**
         * BlockingQueue的接口
         */
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);

        /**
         * 生产者线程
         */
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String data = Integer.toString(new Random().nextInt(10));
                    System.out.println(Thread.currentThread().getName() + " ready to put data into queue");
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                        queue.put(data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " has put " + data + " into queue, QUEUE_SIZE=" + queue.size());
                }
            }).start();
        }

        /**
         * 消费者线程
         */
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    String data = "";
                    System.out.println(Thread.currentThread().getName() + " Ready to take data from  queue");
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                        data = queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " take data:" + data + ", QUEUE_SIZE=" + queue.size());
                }
            }
        }).start();
    }

}
