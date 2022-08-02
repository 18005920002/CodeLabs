package com.labs.designpattern.ch01.ex03;

/**
 * ��ͷѼ
 *
 * @author win
 */
public class MallardDuck extends Duck {


    public MallardDuck() {
        f = new FlyWithWings();
        q = new Quack();
    }

    public void display() {
        System.out.println("Green Head.");
    }

}
