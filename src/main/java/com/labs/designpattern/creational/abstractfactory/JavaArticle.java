package com.labs.designpattern.creational.abstractfactory;

/**
 * @author tanyun.zheng
 * @date 2022/8/2 20:51
 */
public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("Java article");
    }
}
