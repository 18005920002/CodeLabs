package com.labs.designpattern.strategy.compare;

public class Person {
	
	int age;
	String name;
	double salary;
	
	public Person(String name,int age,double salary){
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString(){
		String str = name + ":" + age + ":" + salary;
		return str;
	}
	
	
	
}
