package com.labs.jdk5.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
    public static void main(String[] args) {
        Enhancer e = new Enhancer();
        e.setSuperclass(TargetObject.class);
        e.setCallback(new TargetInterceptor());

        TargetObject to = (TargetObject) e.create();
        System.out.println(to);
        System.out.println(to.add(2, 3));
    }
}
