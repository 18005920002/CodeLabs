package com.labs.java8.api;

/**
 * @author tanyun.zheng
 * @date 2020/12/8 13:47
 */
public class StringTest {
    public static String s1 = "12345678901234567890";
    public static String s2 = "abcdefghijklmnopqrstuvwxyz";
    private final String f1;
    private final String f2 = "xxx";

    public StringTest(String f1) {
        this.f1 = f1;
        System.out.println(f2);
    }

    public static void main(String[] args) {
        StringTest st = new StringTest("abc");
        System.out.println(st.f1);
        System.out.println(s1.substring(4));
    }
}
