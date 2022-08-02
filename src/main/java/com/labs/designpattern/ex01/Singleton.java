package com.labs.designpattern.ex01;

/**
 * ����ģʽ
 *
 * @author win
 */
public class Singleton {

    //��̬���������������ֻ�����ֽ������ʱ����һ�Σ�����ʵ�������ٸ����󣬸ñ���ֻ��1���������ж�����
    private static Singleton unique;

    //˽�й�����ֻ��������ڲ����ܷ���
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (unique == null) {
            unique = new Singleton();
        }
        return unique;
    }
}
