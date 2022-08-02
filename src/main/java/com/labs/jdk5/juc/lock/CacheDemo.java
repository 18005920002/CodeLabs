package com.labs.jdk5.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {

    private Map<String, Object> cache = new HashMap<String, Object>();
    ReadWriteLock rl = new ReentrantReadWriteLock();

    public static void main(String[] args) {

    }

    public /*synchronized*/ Object getData(String key) {

        rl.readLock().lock();
        Object value = null;

        try {
            value = cache.get(key);

            if (value == null) {    //如果数据不在缓存
                rl.readLock().unlock();
                rl.writeLock().lock();
                value = "QUERY FROM REMOTE";
            }
        } finally {
            rl.writeLock().unlock();
            rl.readLock().unlock();
        }

        return value;
    }

    public void putData(Object obj) {

    }
}
