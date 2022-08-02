package com.labs.concurrent;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/22
 */
public class CcrMain {

    private volatile long count = 0;

    public static void main(String[] args) throws Exception {
        final CcrMain test = new CcrMain();
        System.out.println(test.calc());
    }

    private synchronized void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public long calc() throws Exception {

        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            add10K();
        });
        Thread th2 = new Thread(() -> {
            add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return count;
    }
}
