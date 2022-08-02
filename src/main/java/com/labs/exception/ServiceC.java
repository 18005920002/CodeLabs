package com.labs.exception;

/**
 * @author tanyun.zheng
 * @date 2020/11/9 9:28
 */
public class ServiceC {
    public void doc() {
        new ServiceD().doWithException();
    }
}
