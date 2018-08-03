package com.labs.designpattern.strategy.price;

/**
 * 针对不同的会员计算图书的价格
 * @author win10
 */
public interface MemberStrategy {
	
	public double calcPrice(double bookPrice);
}
