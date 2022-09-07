package com.labs.designpattern.creational.factorymethod;

/**
 * @author tanyun.zheng
 * @date 2022/8/2 20:52
 */
public class Test {
    public static void main(String[] args) {
        //切换工厂就切换了产品
        VideoFactory factory = new JavaVideoFactory();
        Video video = factory.getVideo();
        video.produce();
    }
}
