package com.labs.designpattern.creational.factorymethod;

/**
 * @author tanyun.zheng
 * @date 2022/8/5 22:15
 */
public class PythonVideoFactory extends VideoFactory{
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
