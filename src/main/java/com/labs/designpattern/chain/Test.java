package com.labs.designpattern.chain;

public class Test {
	public static void main(String[] args) {
		String id = "21102981234930037";
		//String id = "31102981234930037";
		System.out.println("开始检查号码 [ "+id+" ] 的归属地...");
		Handler bj = new Beijing();
		Handler sh = new Shanghai();
		Handler tj = new Tianjin();
		
		//bj.handleRequest(id);
		bj.setNextHandler(sh);
		sh.setNextHandler(tj);
		
		bj.handleRequest(id);
	}
}
