package com.book.demo;

public class MutablePoint {
	public int x, y;
	public MutablePoint() {
		x = 0;
		y = 0;
	}
	MutablePoint(MutablePoint p) {
		this.x = p.x;
		this.y = p.y;
	}
}
