package com.labs.designpattern.ex01;

/**
 * ���ϣ������
 *
 * @author win
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 0.99;
    }

}
