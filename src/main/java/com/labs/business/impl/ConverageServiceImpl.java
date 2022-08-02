package com.labs.business.impl;

import com.labs.business.ConverageService;

import java.io.Serializable;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/3/3
 */
public class ConverageServiceImpl implements ConverageService {

    @Override
    public String sayHello() {
        System.out.println("sayHello()");
        return "Hello";
    }

    @Override
    public String sayHelloWithParam(String s) {
        System.out.println("sayHelloWithParam()");
        return "Hello, " + s;
    }
}
