package com.staticvoid.dsa.basics.sorting;

/**
 * Time Complexity is O(n^2), space complexity is O(1)
 */

public class InsertionSort extends Sorting {

	public static void main(String[] args) {
		Sorting sort = new InsertionSort();
		sort.sort();

		System.out.println(6789 % 10);
		System.out.println(6789 / 10);
	}


	@Override
	public void sortArray(int[] input) {

		printArray(input, false);

		for (int j = 1; j < input.length; j++) {
			int curr = input[j];
			int i = j - 1;

			while (i >= 0 && input[i] > curr) {
				input[i + 1] = input[i];
				i--;
			}
			input[i + 1] = curr;
		}


		printArray(input, true);

	}

}
