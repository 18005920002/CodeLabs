package com.labs.jdk5.juc.lock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 3个读线程,3个写线程
 *
 * @author win10
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        final Queue3 q3 = new Queue3();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    q3.get();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    q3.put(new Random().nextInt(10));
                }
            }).start();
        }

    }

}

class Queue3 {

    public Queue3() {
    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private Object data = null;//共享数据

    public void get() {
        try {
            rwl.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " is getting data...");
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(Thread.currentThread().getName() + " has got data:" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
    }

    ;


    public void put(Object data) {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is putting data...");
            Thread.sleep(new Random().nextInt(1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " has puted data:" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }

}
