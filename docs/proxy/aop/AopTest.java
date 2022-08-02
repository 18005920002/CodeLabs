package com.labs.jdk5.proxy.aop;

import java.io.InputStream;

public class AopTest {
    public static void main(String[] args) {
        InputStream ins = AopTest.class.getResourceAsStream("config.properties");
        Object obj = new BeanFactory(ins).getBean("xxx");
        System.out.println(obj.getClass().getName());
    }
}
