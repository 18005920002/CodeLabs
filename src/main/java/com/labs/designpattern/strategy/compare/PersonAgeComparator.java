package com.labs.designpattern.strategy.compare;

public class PersonAgeComparator implements IComparator {


    @Override
    public int compare(Object o1, Object o2) {

        Person p1 = (Person) o1;
        Person p2 = (Person) o2;

        if ((p1.getAge() - p2.getAge()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

}
