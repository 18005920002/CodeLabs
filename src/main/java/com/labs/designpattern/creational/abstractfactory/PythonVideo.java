package com.labs.designpattern.creational.abstractfactory;

/**
 * @author tanyun.zheng
 * @date 2022/8/2 20:51
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("python video");
    }
}
