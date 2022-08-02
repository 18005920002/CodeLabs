package com.labs.designpattern.ch02.ex02;

import java.util.Observer;

public class AppTest {
    public static void main(String[] args) {
        WeatherData wd = new WeatherData();
        Observer o1 = new CurrentConditionsDisplay(wd);
        //Observer o2 = new BoardHeatIndex(wd);

        wd.setMeasurements(30, 67, 0);
        wd.setMeasurements(40, 78, 0);
        wd.setMeasurements(46, 88, 0);
    }
}
