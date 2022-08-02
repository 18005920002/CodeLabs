package com.labs.designpattern.ex01;

/**
 * �ص�����
 *
 * @author win
 */
public class LightOffCommand implements Command {
    private Light l;

    public LightOffCommand(Light l) {
        this.l = l;
    }

    @Override
    public void execute() {
        l.off();
    }

    @Override
    public void undo() {
        l.on();
    }
}