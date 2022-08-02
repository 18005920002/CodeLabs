package com.labs.designpattern.ch02.ex02;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayBoard {

    Observable observable;
    private float temp;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("Current: temp = " + temp + ", humidity = " + humidity);
    }

    @Override
    public void update(Observable obs, Object arg1) {
        // TODO Auto-generated method stub
        if (obs instanceof WeatherData) {
            WeatherData wd = (WeatherData) obs;
            this.temp = wd.getTemp();
            this.humidity = wd.getHumidity();
            display();
        }
    }

}
