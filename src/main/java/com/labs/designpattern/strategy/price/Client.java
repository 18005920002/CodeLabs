package com.labs.designpattern.strategy.price;


/**
 * 策略模式定义了一系列的算法，并将每一个算法封装起来，而且使他们可以相互替换，让算法独立于使用它的客户而独立变化�??
 * 
 * 结合工厂模式可以根据不同的情况获取不同的策略
 * 
 * @author win10
 *
 */
public class Client {
	
	public static void main(String[] args) {
		AdvancedMemberStrategy ams = new AdvancedMemberStrategy();
		Price price = new Price(ams);
		System.out.println("折扣后价格为�?"+price.quote(100));
	}
}
