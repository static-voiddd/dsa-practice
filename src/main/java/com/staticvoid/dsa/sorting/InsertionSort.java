package com.staticvoid.dsa.sorting;

/**
 * Time Complexity is O(n^2), space complexity is O(1)
 */

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		sort.sortArray(new int[] { 5, 1, 0, 4, 9, 6 });
		sort.sortArray(new int[] { 5, 1, 1, 4, 9, 0 });

	}

	/*-
	 *
	 5 1 0 4 9 6
	 1 5 0 4 9 6
	   i j replace i +1, curr = 0
	 1 0 5 4 9 6
	 i   j replace i+1
	   1 5 4 9 6 ends
	 0 1 5 4 9 6  0,1,5 is sorted now
	 */


	public int[] sortArray(int[] input) {

		System.out.println("----");

		for (int i : input) {
			System.out.print(i + " ");
		}

		System.out.println();

		for (int j = 1; j < input.length; j++) {
			int curr = input[j];
			int i = j - 1;

			while (i >= 0 && input[i] > curr) {
				input[i + 1] = input[i];
				i--;
			}
			input[i + 1] = curr;
		}


		for (int i : input) {
			System.out.print(i + " ");
		}

		System.out.println("");

		return input;

	}

}
