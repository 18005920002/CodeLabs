package com.labs.designpattern.command;

/**
 * 具体的命令：攻击命令
 * 
 * 
 * <p>Title: AttackCommand</p>
 * <p>Description: </p>
 * <p>www.labs.com</p>
 * @author win
 * @version 1.0
 */
public class AttackCommand implements Command{

	private Reciver reciver;
	
	public AttackCommand(Reciver reciver){
		this.reciver = reciver;
	}
	
	@Override
	public void execute() {
		reciver.attack();
	}

}
