package com.labs.designpattern.ex01;

public class NoCommand implements Command {

    @Override
    public void execute() {
        //Do NOTHING
    }

    @Override
    public void undo() {

    }
}
