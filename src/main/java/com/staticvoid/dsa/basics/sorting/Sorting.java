package com.staticvoid.dsa.basics.sorting;

public abstract class Sorting {

	private int[] originalArray1;
	private int[] originalArray2;
	private int[] originalArray3;
	private int[] originalArray4;
	private int[] originalArray5;

	protected Sorting() {
		originalArray1 = new int[] { 5, 1, 0, 4, 9, 6 };
		originalArray2 = new int[] { 5, 1, 1, 4, 9, 0 };
		originalArray3 = new int[] { 5, -1, 2, 4, -3, 1 };
		originalArray4 = new int[] { 5, 10, 100, -4, -9, 0 };
		originalArray5 = new int[] { 5, 10, 15, 40, 90, 100 };
	}

	public void printArray(int[] input, boolean afterSort) {

		for (int i : input) {
			System.out.print(i + " ");
		}

		System.out.println();

		if (afterSort) {
			System.out.println("----End of Sorted list----");
		}
	}

	public void sort() {
		sortArray(originalArray1);

		sortArray(originalArray2);

		sortArray(originalArray3);

		sortArray(originalArray4);
		sortArray(originalArray5);

	}

	public abstract void sortArray(int[] input);

}
