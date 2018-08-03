package com.labs.designpattern.singleton;

/**
 * 饿汉式单例，基于classloder机制避免了多线程的同步问题。
 * 潜在缺点：由于一加载就实例化，譬如 Singleton 实例的创建是依赖参数或者配置文件的，
 * 在 getInstance() 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了。
 * 
 * <p>Title: HungrySingleton</p>
 * <p>Description: </p>
 * <p>www.labs.com</p>
 * @author win
 * @version 1.0
 */
public class HungrySingleton {
	
	private static HungrySingleton singleton = new HungrySingleton();
	
	private HungrySingleton(){}
	
	public static HungrySingleton getInstance(){
		return singleton;
	}
}
