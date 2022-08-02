package com.labs.java8.juc.thread;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/14
 */
public class RunnableTicketSaleWindow {
    public static void main(String[] args) {
        TickSaleWindow win = new TickSaleWindow();
        Thread t1 = new Thread(win);
        Thread t2 = new Thread(win);
        Thread t3 = new Thread(win);
        t1.start();
        t2.start();
        t3.start();
    }
}

class TickSaleWindow implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            sale();
        }
    }

    private synchronized void sale() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " sales :" + tickets);
            tickets--;
        }
    }
}
