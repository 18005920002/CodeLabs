package com.labs.designpattern.ch01.ex02;

/**
 * ��ͷѼ
 *
 * @author win
 */
public class MallardDuck extends Duck implements Flyable, Quackable {

    public void display() {
        System.out.println("Green Head.");
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
