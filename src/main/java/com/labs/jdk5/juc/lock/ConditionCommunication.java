package com.labs.jdk5.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Conditiona线程通信
 *
 * @author win10
 */
public class ConditionCommunication {

    public static void main(String[] args) {

        final Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 5; i++) {
            business.main(i);
        }
    }
}

/**
 * 需要同步和通讯的方法，要放到一个线程索要访问的资源所在的专门的类里面，不要放在线程里面实现互斥和同步
 *
 * @author win10
 */
class Business {

    Lock lock = new ReentrantLock();
    Condition cond = lock.newCondition();
    private boolean bShouldSub = true;

    void sub(int i) {
        lock.lock();
        while (!bShouldSub) {
            try {
                cond.await();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        try {
            for (int j = 1; j <= 6; j++) {
                System.out.println("Sub Thread:" + j + ", loop of " + i);
            }
            bShouldSub = false;
            cond.signal();
        } finally {
            lock.unlock();
        }
    }

    void main(int i) {

        lock.lock();
        while (bShouldSub) {
            try {
                cond.await();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        try {
            for (int j = 1; j <= 5; j++) {
                System.out.println("main Thread:" + j + ", loop of " + i);
            }
            bShouldSub = true;
            cond.signal();
        } finally {
            lock.unlock();
        }

    }
}

