package com.staticvoid.dsa.basics.sorting;

/**
 * Time Complexity is O(nlogn), space complexity is O(n)
 */

public class MergeSort extends Sorting {

	public static void main(String[] args) {
		new MergeSort();
	}

	MergeSort() {
		sort();
	}

	// merge takes O(n)
	private void merge(int[] arr, int left, int mid, int right) {
		int leftP = left;
		int rightP = mid + 1;
		int[] dummy = new int[right + 1];
		int dummyIndex = 0;

		while (leftP <= mid && rightP <= right) {
			if (arr[leftP] < arr[rightP]) {
				dummy[dummyIndex++] = arr[leftP++];
			} else {
				dummy[dummyIndex++] = arr[rightP++];
			}
		}

		while (leftP <= mid) {
			dummy[dummyIndex++] = arr[leftP++];
		}

		while (rightP <= right) {
			dummy[dummyIndex++] = arr[rightP++];
		}

		dummyIndex = 0;

		for (int i = left; i <= right; i++) {
			arr[i] = dummy[dummyIndex++];
		}

	}

	// just sort takes O(logn)
	// merge takes O(n)
	// total O(nlogn)

	public void sort(int[] arr, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	@Override
	public void sortArray(int[] input) {
		System.out.println("Merge Sort - ");

		printArray(input, false);

		sort(input, 0, input.length - 1);

		printArray(input, true);

	}

}
