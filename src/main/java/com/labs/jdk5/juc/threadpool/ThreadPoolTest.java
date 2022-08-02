package com.labs.jdk5.juc.threadpool;

public class ThreadPoolTest {

    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //ExecutorService cachedPool = Executors.newCachedThreadPool();
		/*ExecutorService singlePool = Executors.newSingleThreadExecutor();//单线程，死后可以找替补
		
		for(int i=0;i<10;i++){
			final int task = i;
			threadPoolcachedPoolsinglePool.execute(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<10;j++){
						System.out.println(Thread.currentThread().getName()+" is loopin "+j +" of task "+task);
					}
					
				}
			});
			
			//singlePool.shutdown();
		}
		
		System.out.println("All of 10 task has been commited.");*/
        //threadPool.shutdown();
        //threadPool.shutdownNow();
		
		
		/*threadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread task 2");
			}
		});
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread task 3");
			}
		});
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread task 4");
			}
		});*/
		
		
		
		/*ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);//单线程，死后可以找替补
		pool.schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"XXX");
			}
		}, 3, TimeUnit.SECONDS);
		
		pool.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+": XXX");
			}
		}, 3,1, TimeUnit.SECONDS);*/

        //ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)
    }
}
