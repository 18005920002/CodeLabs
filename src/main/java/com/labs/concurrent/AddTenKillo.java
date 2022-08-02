package com.labs.concurrent;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/8/26
 */
public class AddTenKillo {
    private static long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000000) {
            count += 1;
        }
    }

    public static long calc() throws Exception {
        final AddTenKillo test = new AddTenKillo();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(AddTenKillo.calc());
    }
}
