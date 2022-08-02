package com.labs.designpattern.ch09;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu {

    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs,and toast", true, 2.99);
        addItem("Regular Pancake Breakfast", "Panckes with fried eggs,sausage", false, 2.99);
        addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.99);
        addItem("Walffles", "Waffles,with your choice of blueberries or strawberries", true, 3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }
	
/*	public ArrayList getMenuItems(){
		return menuItems;
	}*/

    //��ʹ���Զ����Iterator
    public Iterator createIterator() {
        //return new PancakeHouseMenuIterator(menuItems);
        return menuItems.iterator();
    }
}
