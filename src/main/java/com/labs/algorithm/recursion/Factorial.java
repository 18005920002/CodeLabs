package com.labs.algorithm.recursion;

import java.math.BigDecimal;

/**
 * Title Factorial.java
 *
 * Description 递归思想的应用: 计算阶乘 r = n * (n-1)* ... * 3 * 2 * 1
 * 使用递归方法实现，需要使用系统的栈来暂存方法及其参数，对问题规模不确定的情况，将导致栈溢出（StackOverflowError）
 *
 * @author win10
 * @version 1.0 2018/9/26 09:53
 */
public class Factorial {

    /**
     * 阶乘的递归实现
     * @param n 阶数
     * @return BigDecimal
     */
    public static BigDecimal factorial(int n){
        if(n == 1){
            return BigDecimal.ONE;  //递归结束条件
        }
        return BigDecimal.valueOf(n).multiply(factorial(n-1));//提取重复的逻辑，缩小问题规模
    }

    /**
     * 阶乘的非递归实现（自顶向下）
     * @param n 阶数
     * @return BigDecimal
     */
    public static final BigDecimal factorialNR(int n){
        BigDecimal r = BigDecimal.valueOf(n);
        while (n>1) {
            r = r.multiply(BigDecimal.valueOf(--n));
        }
        return r;
    }

    /**
     * 阶乘的非递归实现（自底向上）
     * @param n 阶数
     * @return BigDecimal
     */
    public static final BigDecimal factorialNR2(int n){
        BigDecimal r = BigDecimal.ONE;
        int i=1;
        while (i<n) {
            r = r.multiply(BigDecimal.valueOf(i + 1));
            i++;
        }
        return r;
    }

    public static void main(String[] args) {
        int i = 10000;      //int i = 100000; java.lang.StackOverflowError
        System.out.println(factorial(i));
        System.out.println(factorialNR(i));
        System.out.println(factorialNR2(i));
    }
}
