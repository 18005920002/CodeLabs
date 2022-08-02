package com.labs.test.coverage;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/3/3
 */
public class ConverageTest {
    @Test
    public void test() {
        System.out.println();
    }

    @Test
    public void testMap() {
        Map<Long, String> userMap = new HashMap<>();
        userMap.putIfAbsent(-1L, "系统");
        userMap.putIfAbsent(1L, "AA");
        System.out.println("::" + userMap.getOrDefault(null, ""));
        System.out.println("::" + userMap.getOrDefault(-1L, ""));
        System.out.println("::" + userMap.getOrDefault(1L, ""));
    }
}
