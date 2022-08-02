package com.labs.designpattern.ex01;

/**
 * �����ࣺ�ͻ���
 * ���𴴽�һ�����������������������
 *
 * @author win
 */
public class RemoteControlTest {

    public static void main(String[] args) {

        //�����ߣ�Invoker��
        SimpleRemoteControl src = new SimpleRemoteControl();

        //����Ľ�����
        Light light = new Light();
        GarageDoor gd = new GarageDoor();

        //����������������ý�����
        LightOnCommand command = new LightOnCommand(light);
        GarageDoorOpenCommand gdoc = new GarageDoorOpenCommand(gd);


        src.setCommand(command);
        src.buttonWasPressed();

        src.setCommand(gdoc);
        src.buttonWasPressed();
    }
}
