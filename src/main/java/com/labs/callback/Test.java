package com.labs.callback;

public class Test {
	public static void main(String[] args) {
		LiAnswer li = new LiAnswer();
		WangAsk wang = new WangAsk(li);
		wang.ask("1+1=?");
	}
}
