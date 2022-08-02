package com.labs.designpattern.ex01;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;    //��¼��һ������

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];    //�����¼����
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];//�����¼����
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    public String toString() {
        //��ӡ��ǰң�������ص�������������������������
        StringBuffer sb = new StringBuffer();
        sb.append("\n----RemoteControl----\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("slot[" + i + "] " + onCommands[i].getClass().getName() + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }
}
