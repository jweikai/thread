package com.thread2.phaser2;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable{
	private Phaser phaser;
	public Student(Phaser phaser) {
		this.phaser = phaser;
	}
	
	@Override
	public void run() {
		System.out.printf("%s: Has arrived to do the exam.%s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();	//state = 0 阶段0
		System.out.printf("%s: is going to do the first exercise.%s\n", Thread.currentThread().getName(), new Date());
		doExercise1();
		System.out.printf("%s: has done the first exercise %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();//state = 1 阶段1
		System.out.printf("%s: is going to do the second exercise.%s\n", Thread.currentThread().getName(), new Date());
		doExercise2();
		System.out.printf("%s: has done the second exercise %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();//state = 2 阶段2
		System.out.printf("%s: is going to do the thrid exercise.%s\n", Thread.currentThread().getName(), new Date());
		doExercise3();
		System.out.printf("%s: finished the exam %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();//state = 3 阶段3
	}
	
	private void doExercise1() {
		long duration = (long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void doExercise2() {
		long duration = (long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void doExercise3() {
		long duration = (long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
