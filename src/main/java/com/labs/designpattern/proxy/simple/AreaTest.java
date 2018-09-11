package com.labs.designpattern.proxy.simple;

/**
 * 代理模式测试类
 *
 */
public class AreaTest {

	public static void main(String[] args) {
		
		double a,b,c,area;
		a=5.0d;
		b=4.0d;
		c=15.0d;
		
		//TriangleProxy
		TriangleProxy proxy = new TriangleProxy();
		proxy.setABC(a, b, c);
		area = proxy.getArea();
		System.out.println("Area:"+area);
	}
}
