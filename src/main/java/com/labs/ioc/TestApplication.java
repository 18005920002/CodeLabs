package com.labs.ioc;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/18
 */
public class TestApplication {
    private static List<TestCase> testCases = Lists.newArrayList();

    public static void registe(TestCase testCase) {
        testCases.add(testCase);
    }

    public static void main(String[] args) {
        registe(new UserServiceTest());
        for (TestCase c : testCases) {
            c.run();
        }
    }
}
