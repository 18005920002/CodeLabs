package com.labs.designpattern.ex01;

/**
 * �ɿ�����¯
 *
 * @author win
 */
public class SingleChocolateBoiler {

    private static SingleChocolateBoiler boiler;
    private boolean empty;
    private boolean boiled;

    //������
    private SingleChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    //������̴߳����˶��ʵ��
    public static synchronized SingleChocolateBoiler getInstance() {
        if (null == boiler) {
            boiler = new SingleChocolateBoiler();
        }
        return boiler;
    }

    //����
    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    //����
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isBoiled() {
        return this.boiled;
    }
}
