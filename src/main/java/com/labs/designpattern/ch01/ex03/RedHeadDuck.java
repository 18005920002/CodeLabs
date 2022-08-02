package com.labs.designpattern.ch01.ex03;

/**
 * ��ͷѼ
 *
 * @author win
 */
public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        f = new FlyWithWings();
        q = new Squeak();
    }

    public void display() {
        System.out.println("Red Head.");
    }
}
