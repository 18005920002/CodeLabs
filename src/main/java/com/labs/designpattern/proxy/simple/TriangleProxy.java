package com.labs.designpattern.proxy.simple;

import java.util.logging.Logger;

public class TriangleProxy implements AreaSubject {

    private double a, b, c, area;

    private Triangle realSubject;

    public void setABC(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * 计算三角形面积，先校验是否是三角形，校验通过再调用被代理的原对象的面积计算方法。
     */
    @Override
    public double getArea() {
        if (a + b > c && b + c > a && a + c > b) {
            realSubject = new Triangle(a, b, c);
            area = realSubject.getArea();
            return area;
        } else {
            System.out.println("NOT A VALID TRIANGLE.");
            return -1;
        }

    }

}
