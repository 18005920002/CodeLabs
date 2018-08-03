package com.labs.designpattern.strategy.compare;


/**
 * 比较接口,实现自比�?
 * @author win10
 */
public interface IComparable {
	
	/**
	 * a.compareTo(b)>0  ==  a>b
	 * a.compareTo(b)<0  ==  a<b
	 */
	public int compareTo(Object o);

}
