package com.labs.guava.obj;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/21
 */
public class ToStringTest {
    public static void main(String[] args) {
        DataModel dm = new DataModel();
        dm.setAge(15);
        dm.setGentel(1);
        dm.setName("hello");
        System.out.println(dm);
    }
}
