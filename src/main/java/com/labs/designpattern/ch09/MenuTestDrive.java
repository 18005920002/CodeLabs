package com.labs.designpattern.ch09;

public class MenuTestDrive {
    public static void main(String[] args) {
        Menu phm = new PancakeHouseMenu();
        Menu dm = new DinerMenu();
        Menu cm = new CafeMenu();
        Waitress waitress = new Waitress(phm, dm, cm);
        waitress.printMenu();
    }
}
