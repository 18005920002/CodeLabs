package com.labs.java8.juc.workerthread;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/21
 */
public class MainDriver {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("alice", channel).start();
        new ClientThread("bob", channel).start();
        new ClientThread("blank", channel).start();
    }
}
