package com.labs.designpattern.ch09;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements MyIterator {

    ArrayList menuItems;
    int index = 0;

    public PancakeHouseMenuIterator(ArrayList menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (menuItems.size() < 1 || index >= menuItems.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem item = (MenuItem) menuItems.get(index);
        index++;
        return item;
    }

}
