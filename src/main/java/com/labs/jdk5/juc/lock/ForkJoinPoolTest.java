package com.labs.jdk5.juc.lock;

import java.util.concurrent.RecursiveTask;

/**
 * 分支合并框架
 *
 * @author win10
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {
		/*ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinSum(0L,10000000L);
		//new ForkJoinPoolTest()
		Long sum  =pool.invoke(task);
		System.out.println(sum);*/
        long sum = 0;
        for (long i = 0; i <= 10000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

class ForkJoinSum extends RecursiveTask<Long> {

    private long start;
    private long end;

    private static final long THURSHOLD = 0L; //临界值

    @Override
    protected Long compute() {

        long length = end - start;
        if (length <= THURSHOLD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinSum left = new ForkJoinSum(start, middle);
            left.fork();//进行拆分，压入线程队列

            ForkJoinSum right = new ForkJoinSum(middle + 1, end);
            right.fork();//进行拆分，压入线程队列

            return left.join() + right.join();

        }
    }

    public ForkJoinSum(long start, long end) {
        this.start = start;
        this.end = end;
    }


}