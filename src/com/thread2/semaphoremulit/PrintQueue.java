package com.thread2.semaphoremulit;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 信号量> 0, 时说明有资源可以使用
 * @author ecuser
 *
 */
public class PrintQueue {
	private final Semaphore semaphore;
	private boolean freePrinters[];
	private Lock lockPrinters;
	public PrintQueue() {
		this.semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		for (int i = 0; i < 3; i ++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}
	public void printJob(Object document) {
		try {
			semaphore.acquire();
			int assignedPrinter = getPrinter();
			long duration = (long)(Math.random()*10);
			System.out.printf("%s: PrintQueue: Printing a job during %d seconds\n", Thread.currentThread().getName(), duration);
			TimeUnit.SECONDS.sleep(duration);
			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}
	private int getPrinter() {
		int ret = -1;
		lockPrinters.lock();
		try {
			for (int i = 0; i < freePrinters.length; i ++) {
				if ( freePrinters[i] ) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		}finally {
			lockPrinters.unlock();
		}
		return ret;
	}
}
