package com.labs.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description SLF4J 是日志界面，搭配具体的日志实现框架使用
 * @author win10
 * @Date 2018/9/13 17:39
 */
public class LogTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.info("hello world"); // use logback
    }
}
