package com.labs.designpattern.creational.abstractfactory;

/**
 * 抽象工厂
 * @author tanyun.zheng
 * @date 2022/8/5 23:29
 */
public interface CourseFactory {
    Video getVideo();
    Article getArticle();
}
