package com.labs.java8.juc.workerthread;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/21
 */
public class Channel {

    private static final int MAX_REQUEST = 100;
    private final Request[] requests;
    private final WorkerThread[] threadPool;
    private int tail;
    private int head;
    private int count;

    public Channel(int threadNum) {
        this.requests = new Request[MAX_REQUEST];
        this.threadPool = new WorkerThread[threadNum];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        for (int i = 0; i < threadNum; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        for (WorkerThread w : threadPool) {
            w.start();
        }
    }

    public synchronized void putRequest(Request request) {
        while (count >= requests.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requests[tail] = request;
        tail = (tail + 1) % requests.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requests[head];
        head = (head + 1) % requests.length;
        count--;
        notifyAll();
        return request;
    }

}
