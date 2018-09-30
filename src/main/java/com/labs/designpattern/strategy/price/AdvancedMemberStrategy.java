package com.labs.designpattern.strategy.price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AdvancedMemberStrategy implements MemberStrategy{

	private Logger logger = LoggerFactory.getLogger(AdvancedMemberStrategy.class);

	@Override
	public double calcPrice(double bookPrice) {
		logger.info("对于高级会员的折扣为20%");
        return bookPrice * 0.8;
	}

}
