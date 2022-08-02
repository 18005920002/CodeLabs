package com.labs.jdk5.juc.lock;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(producer, "Producer").start();
        new Thread(consumer, "Consumer").start();
    }
}

/**
 * 店员
 *
 * @author win10
 */
class Clerk {

    private int product = 0;

    /**
     * 进货
     */
    public synchronized void buyin() {
        if (product >= 10) {
            System.out.println("库存已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            this.notify();
        }
    }

    /**
     * 卖货
     */
    public synchronized void sale() {
        if (product <= 0) {
            System.out.println("库存已空");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            this.notify();
        }
    }
}

class Producer implements Runnable {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.buyin();
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}