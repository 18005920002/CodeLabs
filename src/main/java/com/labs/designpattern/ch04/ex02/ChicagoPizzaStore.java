package com.labs.designpattern.ch04.ex02;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new ChicagoSytleCheesePizza();
        }
        return pizza;
    }
}
