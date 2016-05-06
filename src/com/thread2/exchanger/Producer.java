package com.thread2.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Producer implements Runnable{
	private List<String> buffer;
	private final Exchanger<List<String>> exchanger;	//pro com 交换对象
	public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		int cycle = 1;
		for (int i = 0; i < 10; i ++) {
			System.out.printf("Producer: Cycle %d\n", cycle);
			
			for (int j = 0; j < 10; j ++) {
				String message = "Event " + ((i*10) + j);
				System.out.printf("Producer: %s\n", message);
				buffer.add(message);
			}
			
			try {	//创建10个数据与consumer同步
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer: " + buffer.size());
			cycle ++;
		}
	}
}
