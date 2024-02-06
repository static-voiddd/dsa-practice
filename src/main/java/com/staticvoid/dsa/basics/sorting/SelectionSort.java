package com.staticvoid.dsa.basics.sorting;

/**
 * Find minimum and swap with current, start with first index Time Complexity is
 * O(n^2), space complexity is O(1)
 */
public class SelectionSort extends Sorting {

	public static void main(String[] args) {
		Sorting sort = new SelectionSort();
		sort.sort();
	}

	@Override
	public void sortArray(int[] input) {
		System.out.println("Selection Sort - ");

		printArray(input, false);

		for (int i = 0; i <= input.length - 2; i++) {
			int minIndex = i;
			int curr = input[i];
			for (int j = i + 1; j <= input.length - 1; j++) {
				if (input[j] < input[minIndex]) {
					minIndex = j;
				}
			}
			input[i] = input[minIndex];
			input[minIndex] = curr;
		}

		printArray(input, true);

	}

}
