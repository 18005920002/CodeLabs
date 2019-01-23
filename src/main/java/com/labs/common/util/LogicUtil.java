package com.labs.common.util;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 逻辑判断工具
 *
 * @author win10
 * @version v1.0 2019/1/16 14:48
 */
public class LogicUtil {

    /**
     * 不同时为真
     * @param b1
     * @param b2
     * @return
     */
    public static final Boolean mutexTrue(Boolean b1, Boolean b2){
        if(true==b1 && true!=b2 || true!=b1 && true){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(mutexTrue(true,true));
        System.out.println(mutexTrue(true,false));
        System.out.println(mutexTrue(false,true));
        System.out.println(mutexTrue(false,false));
    }
}
