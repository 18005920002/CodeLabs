package com.labs.java8.juc.thredpermsg;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/21
 */
public class Helper {
    public void handler(int count, char c) {
        System.out.println("handler begin");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.println(c);
        }
        System.out.println();
        System.out.println("handler end");
    }

    public void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
