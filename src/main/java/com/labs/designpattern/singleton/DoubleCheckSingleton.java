package com.labs.designpattern.singleton;

/**
 * 双重校验锁
 * 潜在缺点:指令重排
 *
 * <p>Title: DoubleCheckSingleton</p>
 * <p>Description: </p>
 * <p>www.labs.com</p>
 *
 * @author win
 * @version 1.0
 */
public class DoubleCheckSingleton {

    private static /*volatile*/ DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
