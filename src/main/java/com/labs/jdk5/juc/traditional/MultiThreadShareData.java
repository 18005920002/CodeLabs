package com.labs.jdk5.juc.traditional;

public class MultiThreadShareData {


    public static void main(String[] args) {

        final ShareData1 data1 = new ShareData1();

        new Thread(new MyRunnable1(data1)).start();
        new Thread(new MyRunnable2(data1)).start();

    }
}

/**
 * 如果要执行的代码相同，可以用一个Runnable对象来实现多线程数据共享（比如卖票程序）
 * 如果要执行的代码不同，可以用两个Runable对象。（比如一个线程加，一个线程减）
 *
 * @author win10
 */

class MyRunnable1 implements Runnable {
    private ShareData1 data1;

    public MyRunnable1(ShareData1 data1) {
        this.data1 = data1;
    }

    @Override
    public void run() {
        data1.decrement();
    }

}


class MyRunnable2 implements Runnable {
    private ShareData1 data1;

    public MyRunnable2(ShareData1 data1) {
        this.data1 = data1;
    }

    @Override
    public void run() {
        data1.increment();
    }

}

class ShareData1 {

    private int j = 0;

    public void increment() {
        j++;
    }

    public void decrement() {
        j--;
    }

}
