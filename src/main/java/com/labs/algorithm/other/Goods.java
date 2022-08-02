package com.labs.algorithm.other;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * Description
 *
 * @author tanyun.zheng
 * @version v1.0 2019/3/8 9:46
 */

public class Goods {
    private String color;
    private String batch;
    private String weightLevel;
    private String priceLevel;
    private String sn;

    public Goods(String color, String batch, String weightLevel, String priceLevel, String sn) {
        this.color = color;
        this.batch = batch;
        this.weightLevel = weightLevel;
        this.priceLevel = priceLevel;
        this.sn = sn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getWeightLevel() {
        return weightLevel;
    }

    public void setWeightLevel(String weightLevel) {
        this.weightLevel = weightLevel;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return this.getColor() + ":" + this.batch + ":" + this.weightLevel + ":" + this.priceLevel + ":" + sn;
    }
}
