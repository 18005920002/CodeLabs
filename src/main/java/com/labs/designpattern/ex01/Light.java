package com.labs.designpattern.ex01;

/**
 * ��ƣ�����Ľ����ߣ�Reciver��
 *
 * @author win
 */
public class Light {

    /**
     * ����ĵ�
     */
    private String room;

    public Light() {
    }

    public Light(String room) {
        this.room = room;
    }

    /**
     * ����
     */
    public void on() {
        System.out.println(room + " light is on.");
    }

    /**
     * �ص�
     */
    public void off() {
        System.out.println(room + " light is off.");
    }
}
