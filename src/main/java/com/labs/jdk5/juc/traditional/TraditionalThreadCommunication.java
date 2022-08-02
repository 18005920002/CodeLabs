package com.labs.jdk5.juc.traditional;

public class TraditionalThreadCommunication {
    public static void main(String[] args) {

        final Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
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

    private boolean bShouldSub = true;

    synchronized void sub(int i) {
        if (!bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 5; j++) {
            System.out.println("Sub Thread:" + j + ", loop of " + i);
        }
        bShouldSub = false;
        this.notify();
    }

    synchronized void main(int i) {
        if (bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 20; j++) {
            System.out.println("main Thread:" + j + ", loop of " + i);
        }
        bShouldSub = true;
        this.notify();
    }
}