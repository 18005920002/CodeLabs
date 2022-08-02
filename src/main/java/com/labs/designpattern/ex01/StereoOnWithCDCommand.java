package com.labs.designpattern.ex01;

/**
 * ���첥��CD������
 *
 * @author win
 */
public class StereoOnWithCDCommand implements Command {

    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolumn(11);
    }

    @Override
    public void undo() {

    }

}
