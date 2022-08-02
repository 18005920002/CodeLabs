package com.labs.designpattern.singleton;

/**
 * 懒汉式单例模式，为避免多线程创建，需要同步获取实例的代码
 *
 * <p>Title: LazySingleton</p>
 * <p>Description: </p>
 * <p>www.labs.com</p>
 *
 * @author win
 * @version 1.0
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
