package com.labs.designpattern.ch01.ex02;

public class Test {

    public static void main(String[] args) {
        MallardDuck d1 = new MallardDuck();
        d1.quack();
        d1.display();

        RedHeadDuck d2 = new RedHeadDuck();
        d2.quack();
        d2.display();
    }
}
