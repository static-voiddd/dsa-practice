package com.staticvoid.dsa.basics.sorting;

/**
 * Adjacent swapping, pushes max to last Time Complexity is O(n^2), space
 * complexity is O(1)
 *
 * We can optimize to make it slightly better if we have sorted array/ elements
 * if all sorted it can be O(n)
 *
 */

public class BubbleSort extends Sorting {

	public static void main(String[] args) {
		Sorting sort = new BubbleSort();
		sort.sort();
	}

	// 5 10 100 -4 -9 0

	@Override
	public void sortArray(int[] input) {
		System.out.println("Bubble Sort - ");

		printArray(input, false);

		for (int i = input.length - 1; i >= 0; i--) {
			boolean swapHappened = false;
			for (int j = 0; j <= i - 1; j++) {
				if (input[j] > input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
					swapHappened = true;
				}
			}
			if (!swapHappened) {
				// if no swap happened on first pass, we know its sorted array
				// no need to check and compare further
				System.out.println("No swapping so we break " + i);
				break;
			}
		}

		printArray(input, true);

	}

}
