package com.labs.jdk5.lambda;

@FunctionalInterface
public interface MyFunInterface<R, T> {

    public R getValue(T o1, T o2);

}
