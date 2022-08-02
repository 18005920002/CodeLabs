package com.labs.java8.juc.thredpermsg;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/21
 */
public class MainDriver {
    public static void main(String[] args) {
        Host host = new Host();
        host.request(500, 'A');
        host.request(500, 'B');
        host.request(500, 'C');
    }
}
