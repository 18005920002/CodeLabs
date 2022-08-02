package com.labs.designpattern.ch04.ex02;

public class ChicagoSytleCheesePizza extends Pizza {

    public ChicagoSytleCheesePizza() {
        name = "Chicago Sytle Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
