package com.thread2.bank;

public class Demo {
	public static void main(String[] args) {
		Long a = 6133441595816681611L;
		System.out.println(Long.toBinaryString(a));
		System.out.println(Long.toBinaryString(6133441301577867402L));
		System.out.println(Long.toBinaryString(6133441300051140745L));
		
		String time = Long.toBinaryString(System.currentTimeMillis());
		System.out.println(time);
		System.out.println(time.length());
	}
}
