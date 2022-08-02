package com.labs.designpattern.ex01;

public class Stereo {

    private int v;
    private String room;

    public Stereo() {
    }

    ;

    public Stereo(String room) {
        this.room = room;
    }

    public void on() {
        System.out.println(room + "Stereo is on.");
    }

    public void setCD() {
        System.out.println(room + "Stereo is set for CD input.");
    }

    public void setVolumn(int v) {
        this.v = v;
        System.out.println(room + "Stereo volumn is set to " + v);
    }

    public void off() {
        System.out.println(room + "Stereo is off.");
    }
}
