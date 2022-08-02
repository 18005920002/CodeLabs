package com.labs.designpattern.ch08;

/**
 * ����������
 *
 * @author win
 */
public abstract class CaffeinBeverageWithHook {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
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

    //HOOK ���ӷ���
    public boolean customerWantsCondiments() {
        return true;
    }

}
