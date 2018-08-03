package com.labs.designpattern.command;

public class Test {
	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		Command command = new AttackCommand(new Reciver());
		invoker.setCommand(command);
		invoker.sendCommand();
		
	}
}
