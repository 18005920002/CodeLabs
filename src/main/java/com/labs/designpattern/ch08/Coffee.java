package com.labs.designpattern.ch08;

/**
 * ������
 *
 * @author win
 */
public class Coffee extends CaffeinBeverage {

    //���ݣ���ĥ������
    public void brew() {
        System.out.println("Dripping Coffee through filter"); //ͨ���������γ�����
    }

    //���Ǻ�ţ��
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
