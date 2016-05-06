package com.thread2.phaser;

import java.util.concurrent.Phaser;

public class Main {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		FileSearch system = new FileSearch("c:\\Windows", "log", phaser);
		FileSearch app = new FileSearch("c:\\Program Files", "log", phaser);
		FileSearch documents = new FileSearch("C:\\Documents And Settings", "log", phaser);
		Thread sysThread = new Thread(system, "System");
		sysThread.start();
		Thread appThread = new Thread(app, "apps");
		appThread.start();
		Thread docThread = new Thread(documents, "Documents");
		docThread.start();
		try {
			sysThread.join();
			appThread.join();
			docThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Terminated: " + phaser.isTerminated());
	}
}
