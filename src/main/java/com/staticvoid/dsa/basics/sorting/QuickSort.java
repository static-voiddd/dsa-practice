package com.staticvoid.dsa.basics.sorting;

public class QuickSort extends Sorting {

	public static void main(String[] args) {
		Sorting sort = new QuickSort();
		sort.sort();
	}

	public int partition(int nums[], int left, int right) {
		int pivot = nums[right];
		int i = left - 1;

		while (left < right) {
			if (nums[left] < pivot) {
				int temp = nums[left];
				nums[left] = nums[++i];
				nums[i] = temp;
			}
			left++;
		}

		int temp = nums[i + 1];
		nums[i + 1] = pivot;
		nums[right] = temp;
		return i + 1;
	}

	public void quickSort(int[] input, int left, int right) {

		if (left < right) {
			int partition = partition(input, left, right);
			quickSort(input, left, partition - 1);
			quickSort(input, partition + 1, right);
		}

	}

	@Override
	public void sortArray(int[] input) {

		printArray(input, false);
		int indx = input.length - 1;
		quickSort(input, 0, indx);
		printArray(input, true);

	}

}
