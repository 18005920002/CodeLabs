package com.labs.jdk5.proxy.cglib;

public class TargetObject {
    public String getText() {
        return "some text...";
    }

    public int add(int a, int b) {
        int r = a + b;
        System.out.println("a + b = " + r);
        return r;
    }

    public int getCount(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject[]" + getClass();
    }
}
