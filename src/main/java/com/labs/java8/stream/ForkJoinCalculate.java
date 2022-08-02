package com.labs.java8.stream;

import java.util.concurrent.RecursiveTask;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/8
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    private static final long THRESHOLD = 100000;

    @Override
    protected Long compute() {
        return null;
    }
}
