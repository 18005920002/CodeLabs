package com.labs.jdk5.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Conditiona线程通信
 *
 * @author win10
 */
public class ThreeCondition {

    public static void main(String[] args) {

        final Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    business.two(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    business.three(i);
                }
            }
        }).start();

        for (int i = 1; i <= 5; i++) {
            business.main(i);
        }
    }

    static class Business {

        Lock lock = new ReentrantLock();

        Condition cmain = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        private int shouldDo = 1;

        void two(int i) {
            lock.lock();
            while (shouldDo != 2) {
                try {
                    c2.await();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            try {
                for (int j = 1; j <= 6; j++) {
                    System.out.println("Thread TWO:" + j + ", loop of " + i);
                }
                shouldDo = 3;
                c3.signal();
            } finally {
                lock.unlock();
            }
        }


        void three(int i) {
            lock.lock();
            while (shouldDo != 3) {
                try {
                    c3.await();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            try {
                for (int j = 1; j <= 6; j++) {
                    System.out.println("Thread THREE:" + j + ", loop of " + i);
                }
                shouldDo = 1;
                cmain.signal();
            } finally {
                lock.unlock();
            }
        }

        void main(int i) {

            lock.lock();
            while (shouldDo != 1) {
                try {
                    cmain.await();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            try {
                for (int j = 1; j <= 5; j++) {
                    System.out.println("Thread MAIN:" + j + ", loop of " + i);
                }
                shouldDo = 2;
                c2.signal();
            } finally {
                lock.unlock();
            }

        }
    }

/**
 * 需要同步和通讯的方法，要放到一个线程索要访问的资源所在的专门的类里面，不要放在线程里面实现互斥和同步
 * @author win10
 *
 */

}

