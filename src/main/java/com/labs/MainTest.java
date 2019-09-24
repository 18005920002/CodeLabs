package com.labs;

/**
 * Description
 *
 * @author tanyun.zheng
 * @version v1.0 2019/5/15 17:30
 */
public class MainTest {
    public static void main(String[] args) {
        String s ="AB";
        System.out.println(s.hashCode());
        MainTest o = new MainTest();
        o.hashCode();
        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(o);
    }
}
