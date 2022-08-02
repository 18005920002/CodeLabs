package com.labs.designpattern.ch04.ex03;

/**
 * ���󹤳�
 *
 * @author win
 */
public interface PizzaIngredientFactory {

    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClam();
}
