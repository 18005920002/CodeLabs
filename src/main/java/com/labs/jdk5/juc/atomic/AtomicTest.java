package com.labs.jdk5.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子变量与CAS算法
 * <p>
 * volatile保证变量的内存可见性
 * CAS(Compare And Swap)算法保证其原子性，是底层硬件对于并发操作共享数据的支持
 * CAS包含3个操作数
 * 内存值V(更新前最新的内存状态)
 * 预估值A(最开始从内存读出来的旧值)
 * 更新值B(需要写入的新值)
 * 更新值之前，看看内存的初始值是否被动过了，如果被动过了，我就不改了。
 * <p>
 * 当且仅当 V==A 时，V=B，否则什么都不做
 * <p>
 * i++问题
 *
 * @author win10
 */
public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        ai.incrementAndGet();
        ai.getAndIncrement();
        System.out.println(ai);

        //ConcurrentHashMap<K, V>
        //锁分段机制

    }
}
