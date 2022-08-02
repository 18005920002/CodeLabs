package com.labs.jdk5.proxy.dynamic;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {

    private long beginTime = 0;

    @Override
    public void befor(Method m) {
        System.out.println("BEFORE...");
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void after(Method m) {
        System.out.println("AFTER...");
        long endTime = System.currentTimeMillis();
        System.out.println("COST = " + (endTime - beginTime));
    }

    public MyAdvice() {
    }

}
