package com.labs.designpattern.creational.factorymethod;

/**
 * 只定义契约，将实例的创建交给其子类来实现
 *
 * 由于工厂方法可能还有一些已知实现，故用抽象类表示，这里用接口表示也可以
 * @author tanyun.zheng
 * @date 2022/8/2 20:52
 */
public abstract class VideoFactory {
    public abstract Video getVideo();
}
