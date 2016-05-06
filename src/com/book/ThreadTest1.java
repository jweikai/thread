package com.book;

public class ThreadTest1 {
	private static boolean ready;
	private static int number;
	private static class ReadyThread extends Thread {
		@Override
		public void run() {
			while ( !ready ) {
				Thread.yield();
			}
			System.out.println(number);
		}
	}
	public static void main(String[] args) {
		new ReadyThread().start();
		number = 42;
		ready = true; 
	}
}
