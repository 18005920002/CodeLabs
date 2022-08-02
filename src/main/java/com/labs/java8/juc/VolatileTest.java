package com.labs.java8.juc;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/10
 */

public class VolatileTest {
    public static void main(String[] args) {
        VolatileA vt = new VolatileA();
        new Thread(new WriteThread(vt)).start();
        new Thread(new ReadThread(vt)).start();

    }
}

class VolatileA {
    int index = 0;
    volatile boolean flag = false;

    public void write() {
        System.out.println("WRITE:");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        index = 10;

        flag = true;
    }

    public void read() {
        System.out.println("READ:");

        if (flag) {
            System.out.println("TRUE:" + index);
        } else {
            System.out.println("FALSE:" + index);
        }
    }
}

class ReadThread implements Runnable {
    private VolatileA vt;

    public ReadThread(VolatileA vt) {
        this.vt = vt;
    }

    @Override
    public void run() {
        vt.read();
    }
}

class WriteThread implements Runnable {
    private VolatileA vt;

    public WriteThread(VolatileA vt) {
        this.vt = vt;
    }

    @Override
    public void run() {
        vt.write();
    }
}