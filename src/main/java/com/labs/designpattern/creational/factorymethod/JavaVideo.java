package com.labs.designpattern.creational.factorymethod;

/**
 * @author tanyun.zheng
 * @date 2022/8/2 20:51
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("Java video");
    }
}
