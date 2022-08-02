package com.labs.designpattern.ex01;

/**
 * ��ң�����������ߣ�Invoker��
 * ����һ��������󣬲���ĳ��ʱ��������������execute()��������������ʵ�С�
 *
 * @author win
 */
public class SimpleRemoteControl {

    Command slot;

    public SimpleRemoteControl() {

    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
