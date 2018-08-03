package com.labs.designpattern.strategy.price;

public class AdvancedMemberStrategy implements MemberStrategy{

	@Override
	public double calcPrice(double bookPrice) {
		System.out.println("对于高级会员的折扣为20%");
        return bookPrice * 0.8;
	}

}
