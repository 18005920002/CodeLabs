package com.labs.designpattern.ch08;

/**
 * ����
 *
 * @author win
 */
public class Tea extends CaffeinBeverage {

    /**
     * �ݲ��
     */
    public void brew() {
        System.out.println("Steeping the tea");
    }

    /**
     * ������
     */
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
