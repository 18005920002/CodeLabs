package com.labs.java8.juc.workerthread;

import java.util.Random;

/**
 * @Description: 客户端，不断产生任务，往池里放
 * @Author: tanyun.zheng
 * @Date: 2020/4/21
 */
public class ClientThread extends Thread {

    private final Channel channel;
    private final Random random = new Random();

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
