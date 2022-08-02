package com.labs.designpattern.ex01;

/**
 * ���ϣ�����
 *
 * @author win
 */
public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Soy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }

}
