package com.staticvoid.dsa.array.medium;

import java.util.ArrayList;
import java.util.List;

//'arr '= [1,2,3,4,5]
//'k' = 1  rotated array = [2,3,4,5,1]
//'k' = 2  rotated array = [3,4,5,1,2]
//'k' = 3  rotated array = [4,5,1,2,3] and so on.
public class LeftRotateArrayByK {

	public static int[] bruteForce(int[] nums, int k) {

		LeftRotateArrayByK.printArray(nums, k, false);

		k = k % nums.length; // if k is large than array length it will come back to its original

		List<Integer> tempArr = new ArrayList<>();

		// 1. store elements till k on temp place
		for (int i = 0; i < k; i++) {
			tempArr.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			nums[i - k] = nums[i];
		}

		for (int i = nums.length - k; i < nums.length; i++) {
			nums[i] = tempArr.get(i - (nums.length - k));
		}

		LeftRotateArrayByK.printArray(nums, k, true);

		return nums;
	}

	public static void main(String[] args) {
		LeftRotateArrayByK.bruteForce(new int[] { 1, 2, 3, 4, 5 }, 2);
		LeftRotateArrayByK.bruteForce(new int[] { 1, 2, 3, 4, 5 }, 3);
		LeftRotateArrayByK.bruteForce(new int[] { 1, 2, 3, 4, 5 }, 1);
		LeftRotateArrayByK.bruteForce(new int[] { 1, 2, 3, 4, 5 }, 6);
		LeftRotateArrayByK.bruteForce(new int[] { 1, 2, 3, 4, 5 }, 5);

		LeftRotateArrayByK.optimal(new int[] { 1, 2, 3, 4, 5 }, 2);
		LeftRotateArrayByK.optimal(new int[] { 1, 2, 3, 4, 5 }, 3);
		LeftRotateArrayByK.optimal(new int[] { 1, 2, 3, 4, 5 }, 1);
		LeftRotateArrayByK.optimal(new int[] { 1, 2, 3, 4, 5 }, 6);
		LeftRotateArrayByK.optimal(new int[] { 1, 2, 3, 4, 5 }, 5);
	}

	// Reverse array from 0 to k-1
	// Reverse from k to n-1
	// Now reverse entire after above two

	public static int[] optimal(int[] nums, int k) {
		System.out.println("Optimal..");
		LeftRotateArrayByK.printArray(nums, k, false);

		k = k % nums.length;
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);

		LeftRotateArrayByK.printArray(nums, k, true);

		return nums;
	}

	public static void printArray(int[] input, int k, boolean after) {

		for (int i : input) {
			System.out.print(i + " ");
		}

		System.out.println("Rotate by " + k);

		if (after) {
			System.out.println("----End of result----");
		}
	}

	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}

	}
}
