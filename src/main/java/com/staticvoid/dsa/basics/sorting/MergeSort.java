package com.staticvoid.dsa.basics.sorting;

/**
 * Time Complexity is O(n^2), space complexity is O(1) Best time complexity is
 * O(n) if its sorted array
 *
 * Swap curr element with elements to its left till curr element finds its right
 * position
 *
 * we start sorting from left
 */

public class MergeSort extends Sorting {

	public static void main(String[] args) {
		new MergeSort();
	}

	MergeSort() {
		sort();
	}


	@Override
	public void sortArray(int[] input) {
		System.out.println("Merge Sort - ");

		printArray(input, false);

		for (int i = 0; i < input.length; i++) {
			int j = i;
			while (j > 0 && input[j - 1] > input[j]) {
				int temp = input[j - 1];
				input[j - 1] = input[j];
				input[j] = temp;
				j--;
			}
		}


		printArray(input, true);

	}

}
