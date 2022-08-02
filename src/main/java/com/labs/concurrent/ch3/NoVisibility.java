package com.labs.concurrent.ch3;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/9/24
 */
public class NoVisibility {
    private static boolean ready;
    private static int num;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {

            while (!ready) {
                System.out.println("NotReady");
                Thread.yield();
            }
            System.out.println(num);
        }
    }

    public static void main(String[] args) throws Exception {
        new ReaderThread().start();
        Thread.sleep(1000);
        num = 42;
        ready = true;
    }
}



