package com.labs.designpattern.ch02.ex01;

public abstract class Duck {

    Flyable f;
    Quackable q;

    public void swim() {
        System.out.println("Swiming ...");
    }

    public abstract void display();
    //{
    //System.out.println("Hi, I am here.");
    //}

    public void performanceFly() {
        f.fly();
    }

    public void performanceQuack() {
        q.quack();
    }

    public void setFlyable(Flyable f) {
        this.f = f;
    }

    public void setQuackable(Quackable q) {
        this.q = q;
    }
}
