package com.labs.designpattern.ch08;

/**
 * ����������
 *
 * @author win
 */
public abstract class CaffeinBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    //����
    abstract void brew();

    //��ӵ�ζƷ
    abstract void addCondiments();


    //�տ�ˮ

    public final void boilWater() {
        System.out.println("Boiling water");
    }

    //��������
    public final void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
