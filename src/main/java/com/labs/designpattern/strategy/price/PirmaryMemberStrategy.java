package com.labs.designpattern.strategy.price;

/**
 * 高级会员的计算方�?
 *
 * @author win10
 */
public class PirmaryMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double bookPrice) {
        System.out.println("对于初级会员的没有折�?");
        return bookPrice;
    }

}
