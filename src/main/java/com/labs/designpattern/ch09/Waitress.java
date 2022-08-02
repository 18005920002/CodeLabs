package com.labs.designpattern.ch09;

import java.util.Iterator;

public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        Iterator cafeIterator = cafeMenu.createIterator();

        System.out.println("MENU------\nBREAKFAST:");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH:\n");
        printMenu(dinerIterator);
        System.out.println("\nDINNER:\n");
        printMenu(cafeIterator);
    }

    public void printMenu(Iterator it) {
        while (it.hasNext()) {
            MenuItem item = (MenuItem) it.next();
            System.out.print(item.getName() + ",");
            System.out.print(item.getPrice() + "--");
            System.out.println(item.getDescription());
        }
    }
}
