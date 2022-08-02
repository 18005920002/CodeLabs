package com.labs.designpattern.ch04.ex02;

public abstract class PizzaStore {

    //����Ĺ���������ͨ���̳�������������
    public abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {

        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
