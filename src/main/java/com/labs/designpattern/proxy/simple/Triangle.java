package com.labs.designpattern.proxy.simple;

public class Triangle implements AreaSubject{
	
	private double a,b,c,area;
	
	public Triangle(double a,double b,double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * 计算三角形面积
	 * @return
	 */
	@Override
	public double getArea() {
		double p = (a+b+c) / 2.0;
		area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return area;
	}
	
}
