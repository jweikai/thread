package com.book;

import java.io.File;
import java.io.IOException;

import com.twmacinta.util.MD5;

public class Test {
	public static void main(String[] args) throws IOException {
		long t1 = System.currentTimeMillis();
		byte[] buf = MD5.getHash(new File("E://a.txt"));
		System.out.println(MD5.asHex(buf));
		System.out.println(System.currentTimeMillis() - t1);
	}
}

