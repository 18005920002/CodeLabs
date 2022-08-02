package com.labs.designpattern.ch02.ex01;

public class Test {

    public static void main(String[] args) {

        Duck d1 = new MallardDuck();

        d1.performanceFly();
        d1.performanceQuack();
        d1.display();

        Duck d2 = new RedHeadDuck();

        d2.performanceFly();
        d2.performanceQuack();
        d2.display();

        d2.setQuackable(new Quack());
        d2.performanceQuack();

    }
}
