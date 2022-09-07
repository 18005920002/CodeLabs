package com.labs.designpattern.creational.abstractfactory;

/**
 * 扩展产品族方便（扩展一族，只要增加类，不修改已有代码）
 * 但是扩展产品等级麻烦（要修改很多类，违反开闭原则）
 * @author tanyun.zheng
 * @date 2022/8/2 20:52
 */
public class Test {
    public static void main(String[] args) {
        //切换实现类就切换了产品族
        CourseFactory factory = new JavaCourseFactory();
        Video video = factory.getVideo();
        Article article = factory.getArticle();
        video.produce();
        article.produce();
    }
}
