package com.labs.java8.juc.workerthread;

import java.util.Random;

/**
 * @Description: 请求/任务
 * @Author: tanyun.zheng
 * @Date: 2020/4/21
 */
public class Request {
    private final String name;
    private final int number;
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " execute " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[ Request from " + name + " No. " + number + " ]";
    }
}
