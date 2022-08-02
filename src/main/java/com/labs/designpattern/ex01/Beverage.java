package com.labs.designpattern.ex01;

/**
 * ���ϻ���
 *
 * @author win
 */
public abstract class Beverage {

    protected String description = "Unknown Beverage";

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();
}
