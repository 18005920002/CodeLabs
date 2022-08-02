package com.labs.jdk5.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        new LockTest().init();
    }

    private void init() {
        final Outputer op = new Outputer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    op.output("zhangxiaoxiang");
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    op.output("lihuoming");
                }
            }
        });
        t2.start();
    }


    static class Outputer {

        Lock lock = new ReentrantLock();

        public void output(String s) {
            lock.lock();
            try {
                for (int i = 0; i < s.length(); i++) {
                    System.out.print(s.charAt(i));
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }

        void output2(String s) {
            synchronized (Outputer.class) {
                for (int i = 0; i < s.length(); i++) {
                    System.out.print(s.charAt(i));
                }
                System.out.println();
            }
        }

        static synchronized void output3(String s) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }
    }
}
