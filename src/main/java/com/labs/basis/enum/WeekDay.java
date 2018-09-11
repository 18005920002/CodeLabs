package com.labs.advenced.enums;

public enum WeekDay {
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY;
	
	public String toString(){
		if(this==MONDAY)
			System.out.println(MONDAY.name());
		else if(this==WeekDay.TUESDAY){
			System.out.println(TUESDAY.name());
		}
		else System.out.println("ERROR");
		return this.name();
	}
	
	
}
