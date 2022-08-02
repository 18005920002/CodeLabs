package com.labs.designpattern.ch02.ex02;

import java.util.Observable;

public class WeatherData extends Observable {

    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }


    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemp() {
        return this.temp;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public float getPressure() {
        return this.pressure;
    }

}
