package com.labs.callback;

public class WangAsk implements CallBack{

	//Li li;
	private LiAnswer li;
	
	WangAsk (LiAnswer li){
		this.li = li;
	}
	
	
	@Override
	public void solve(String result) {
		System.out.println("小李给的答案是-->"+result);
	}
	
	public void ask(final String question){
		
		new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println("小李，我问你个问题："+question+"想好告诉我，我先去玩了.");
				li.executeMessage(WangAsk.this,question);
			}
		}).start();
		
		play();
	}
	
	public void play(){
		System.out.println("Go to play...");
	}
	
}
