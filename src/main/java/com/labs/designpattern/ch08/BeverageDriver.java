package com.labs.designpattern.ch08;

public class BeverageDriver {
    public static void main(String[] args) {

        TeaWithHook twh = new TeaWithHook();
        CoffeeWithHook cwh = new CoffeeWithHook();
        System.out.println("Making Tea...");
        twh.prepareRecipe();

        System.out.println("Making coffee...");
        cwh.prepareRecipe();
    }
}
