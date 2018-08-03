package com.labs.designpattern.strategy.price;

public class Price {
	
	MemberStrategy memberStrategy;
	
	public Price(MemberStrategy memberStrategy){
		this.memberStrategy = memberStrategy;
	}
	
	public double quote(double bookPrice){
		return memberStrategy.calcPrice(bookPrice);
	}
}
