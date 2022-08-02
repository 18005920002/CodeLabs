package com.labs.designpattern.ch01.ex02;

/**
 * ��ͷѼ
 *
 * @author win
 */
public class RedHeadDuck extends Duck implements Flyable, Quackable {
    public void display() {
        System.out.println("Red Head.");
    }

    @Override
    public void fly() {
        // TODO Auto-generated method stub

    }

    @Override
    public void quack() {
        // TODO Auto-generated method stub
        System.out.println("GA GA GA...");
    }
}
