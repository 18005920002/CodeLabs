package com.labs.jdk5.juc.threadpool;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //pool.execute(command);
        Future<String> f = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "hello";
            }
        });
        System.out.println("Waiting for result");
        try {
            f.cancel(true);
            String retVal = f.get();
            System.out.println("RETURN:" + retVal);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            //e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
            //e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Thread has been canceled");
        }

        ExecutorService pool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(pool2);


        for (int i = 0; i < 10; i++) {
            final int seq = i;
            cs.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(1000));
                    return seq;
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            Future<Integer> fx;
            try {
                fx = cs.take();
                System.out.println(fx.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


    }
}
