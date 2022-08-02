package com.labs.designpattern.ex01;

/**
 * ��������
 *
 * @author win
 */
public class LightOnCommand implements Command {
    private Light l;

    public LightOnCommand(Light l) {
        this.l = l;
    }

    @Override
    public void execute() {
        l.on();
    }

    @Override
    public void undo() {
        l.off();
    }
}