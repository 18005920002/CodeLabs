package com.labs.designpattern.ch08;

/**
 * ����
 *
 * @author win
 */
public class CopyOfTea {

    //׼���ط�
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        addLemon();
        pourInCup();
    }

    /**
     * �տ�ˮ
     */
    public void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * �ݲ��
     */
    public void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    /**
     * ������
     */
    public void addLemon() {
        System.out.println("Adding Lemon");
    }

    /**
     * ��������
     */
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
