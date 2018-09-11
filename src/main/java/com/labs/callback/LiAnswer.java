package com.labs.callback;

public class LiAnswer {
	
	public void executeMessage(CallBack callBack,String question){
		System.out.println("小王，收到你的问题-->"+question);
		System.out.println("wait a second...，等下告诉你");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = "A:2";
		
		callBack.solve(result);
	}
}
