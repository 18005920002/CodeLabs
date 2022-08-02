package com.labs.designpattern.ex01;

/**
 * ���ϣ��ۺϿ���
 *
 * @author win
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }

}
