package com.labs.designpattern.singleton;
/**
 * 使用JVM本身机制保证了线程安全问题；由于 SingletonHolder 是私有的，
 * 除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；
 * 同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
 * 
 * <p>Title: StaticNestedSingleton</p>
 * <p>Description: </p>
 * <p>www.labs.com</p>
 * @author win
 * @version 1.0
 */
public class StaticNestedSingleton {
	
	private StaticNestedSingleton(){}
	
	private static class SingletonHolder{
		private static final StaticNestedSingleton instance = new StaticNestedSingleton();  
	}
	
	public static StaticNestedSingleton getInstance(){
		return SingletonHolder.instance;
	}
}
