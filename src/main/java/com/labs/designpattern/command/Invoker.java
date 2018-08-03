package com.labs.designpattern.command;

/**
 * 请求调用者（命令发起者）
 * 
 * <p>Title: Invoker</p>
 * <p>Description: </p>
 * <p>www.labs.com</p>
 * @author win
 * @version 1.0
 */
public class Invoker {
	private Command command;
	
	public void setCommand(Command command){
		this.command = command;
	}
	
	public void sendCommand(){
		System.out.println("Invoker Start Send Command.");
		command.execute();
	}
}
