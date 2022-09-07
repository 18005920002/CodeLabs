package com.labs.designpattern.creational.simplefactory;

/**
 * @author tanyun.zheng
 * @date 2022/8/2 20:55
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("Python");
    }
}
