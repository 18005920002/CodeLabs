package com.labs.ioc;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/18
 */
public abstract class TestCase {

    public void run() {
        if (doTest()) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail");
        }
    }

    public abstract boolean doTest();
}
