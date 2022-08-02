package com.labs.java8.juc.thredpermsg;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/21
 */
public class Host {
    private Helper helper = new Helper();

    public Host() {
    }

    public void request(int count, char c) {
        System.out.println("Host receive task ...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                helper.handler(count, c);
            }
        }).start();
        System.out.println("Host finish task ...");
    }
}
