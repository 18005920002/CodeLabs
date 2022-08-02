package com.labs.jdk5.juc.lock;

import java.util.Random;
import java.util.concurrent.*;

/**
 * java.util.concurrent.Executor : 负责线程的使用和调度的根接口
 * |--ExecutorServcie 子接口 : 线程池的主接口
 * |--ThreadPoolExceutor 线程池的实现类
 * |-- ScheduledExecutorServcie 子接口： 负责线程调度
 * |--ScheduledThreadPoolExecutor 继承ThreadPoolExceutor，实现ScheduledExecutorServcie
 * <p>
 * 工具类
 * ExecutorServcie pool = Executors.newFixedThreadPool();
 * Executors.newCachedThreadPool();
 * Executors.newSingleThreadPool();
 * ScheduledExecutorServcie spool = Executors.newScheduledThreadPool();
 *
 * @author win10
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
		/*//创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);
		
		//提交任务
		for(int i=0;i<10;i++){
			pool.submit(new Task());
		}
		
		//关闭线程池
		pool.shutdown();*/

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Future f = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + " generate random number=" + num);
                    return num;
                }
            }, 2, TimeUnit.SECONDS);

            try {
                System.out.println("Return:" + f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


    }
}

class Task implements Runnable {
    private int i = 3;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + i);
    }

}