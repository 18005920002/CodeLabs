package com.labs.practice;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/9/2
 */
@Slf4j
public class BooleanUsage {

    public static void main(String[] args) {
        Boolean b = getNullBoolean();
        if (Boolean.TRUE.equals(b)) {
            log.info("return true");
        } else {
            log.info("return false");
        }
    }

    /*private static Boolean getNullBoolean(){
        return null;
    }*/

    private static boolean getNullBoolean() {
        Boolean b = true;
        return b.booleanValue();
    }

    private static Boolean getBoolean() {
        return Boolean.TRUE;
    }

}
