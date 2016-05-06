package com.thread2.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量> 0, 时说明有资源可以使用
 * @author ecuser
 *
 */
public class PrintQueue {
	private final Semaphore semaphore;
	public PrintQueue() {
		this.semaphore = new Semaphore(1);	//构件一个0/1二进制信号量
	}
	public void printJob(Object document) {
		try {
			semaphore.acquire();	//获取信号量
			long duration = (long)(Math.random()*10);
			System.out.printf("%s: PrintQueue: Printing a job during %d seconds\n", Thread.currentThread().getName(), duration);
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();//释放信号
		}
	}
}
