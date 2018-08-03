package com.labs.designpattern.strategy.compare;

public class ComparablePerson implements IComparable{
	
	int age;
	String name;
	double salary;
	
	public ComparablePerson(String name,int age,double salary){
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

	@Override
	public int compareTo(Object o) {
		if(o instanceof ComparablePerson){
			if(((ComparablePerson) o).getSalary()<this.getSalary()){
				return 1;
			}else{
				return -1;
			}
		}
		return 0;
	}
	
}
