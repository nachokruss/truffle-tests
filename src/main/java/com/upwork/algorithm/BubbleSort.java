package com.upwork.algorithm;

import java.util.Random;

public class BubbleSort {
	
	public void run() {
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			int[] array = createArray(1000, random);
			BubbleSort.sortArray(array);
		}
	}

	private int[] createArray(int arraySize, Random random) {
		int[] array = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt(100000);
		}
		return array;
	}
	
	/**
	 * Bubble sorts an array
	 * @param array
	 */
	public static void sortArray(int[] array) {
	    int n = array.length;
	    for (int i = 0; i < n; i++) {
	        for (int j = 1; j < (n - i); j++) {
	            if (array[j - 1] > array[j]) {
	                swapElements(array, j-1, j);
	            }
	        }
	    }
	}

	/**
	 * Swap item at position a with item at position b
	 * 
	 * @param array
	 * @param a
	 * @param b
	 */
	private static void swapElements(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

}
