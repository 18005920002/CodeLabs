package com.labs.java8.juc.container;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/8/3
 */
public class ConcurrentHashMapNormaluse {
    private static final int LOOP_COUNT = 100000;
    private static final int THREAD_COUNT = 10;
    private static final int ITEM_COUNT = 1000;

    public void stastic() {

        ConcurrentHashMap<String, Long> chm = new ConcurrentHashMap(ITEM_COUNT);

        ForkJoinPool pool = new ForkJoinPool(THREAD_COUNT);

        Long start = System.currentTimeMillis();
        pool.execute(() -> {
            IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(i -> {
                String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
                synchronized (chm) {
                    if (chm.containsKey(key)) {
                        chm.put(key, chm.get(key) + 1);
                    } else {
                        chm.put(key, 1L);
                    }
                }
                //chm.computeIfAbsent(key,k-> new LongAdder().increment());
            });
        });
        Long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "\n" + JSON.toJSONString(chm));

    }

    public static void main(String[] args) {
        //new ConcurrentHashMapNormaluse().stastic();
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap(100);

        Integer i1 = map.putIfAbsent("a", 111);
        Integer i2 = map.putIfAbsent("a", 112);
        Integer value = map.get("a");
        System.out.println("replace value " + i2 + " of map");
    }
}
