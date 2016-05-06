package com.thread2.cuspro;

public class Cunsumer implements Runnable{
	private EventStorage storage;
	public Cunsumer(EventStorage storage) {
		this.storage = storage;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i ++) {
			storage.get();
		}
	}
}
