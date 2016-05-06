package com.thread;

public class Demo {
	public static void main(String[] args) {
		A a = new A("jwk", "12") {
			@Override
			public void print() {
				System.out.println(getName());
				System.out.println("haha");
				System.out.println(getAge());
			}
		};
		a.print();
	}
}

class A {
	private String name;
	private String age;
	public A(String name, String age) {
		this.name = name;
		this.age = age;
	}
	public void print() {
		System.out.println(toString());
	}
	public String getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
}
