package com.labs.java8.juc.thread;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/14
 */
public class TicketSaleWindow {
    public static void main(String[] args) {
        Thread t = new Thread(new SaleWindow());
        t.start();
        Thread t2 = new Thread(new SaleWindow());
        t2.start();
        Thread t3 = new Thread(new SaleWindow());
        t3.start();
    }
}

class SaleWindow extends Thread {
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (SaleWindow.class) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + " Sales:" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }


}
