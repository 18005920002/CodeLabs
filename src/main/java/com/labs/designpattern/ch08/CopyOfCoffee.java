package com.labs.designpattern.ch08;

/**
 * ������
 *
 * @author win
 */
public class CopyOfCoffee {

    //׼���ط�
    void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    //�տ�ˮ
    public void boilWater() {
        System.out.println("Boiling water");
    }

    //���ݣ���ĥ������
    public void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter"); //ͨ���������γ�����
    }

    //��������
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    //���Ǻ�ţ��
    public void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }
}
