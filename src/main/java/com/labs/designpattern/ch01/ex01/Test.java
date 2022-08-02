package com.labs.designpattern.ch01.ex01;

public class Test {

    public static void main(String[] args) {
        Duck d1 = new MallardDuck();
        d1.quack();
        d1.display();

        Duck d2 = new RedHeadDuck();
        d2.quack();
        d2.display();
    }
}
