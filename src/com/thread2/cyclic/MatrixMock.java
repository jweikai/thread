package com.thread2.cyclic;

import java.util.Random;

/**
 * @author ecuser
 *
 */
public class MatrixMock {
	private int data[][];
	public MatrixMock(int size, int length, int number) {
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();
		
		for (int i = 0; i < size; i ++) {
			for (int j = 0; j < length; j ++) {
				data[i][j] = random.nextInt(10);
				if ( data[i][j] == number ) {
					counter ++;
				}
			}
		}
		
		System.out.printf("mock: There are %d ocurrentces of number in generated data.\n", counter, number);	//输出初使时number, 和相应测试，以对比答案
	}
	
	public int[] getRow(int row) {
		if ( (row >= 0) && (row < data.length) ) {
			return data[row];
		}
		return null;
	}
}
