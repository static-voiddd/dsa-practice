package com.staticvoid.dsa.array.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionOfSortedArrays {

	public static void bruteForce(int[] nums, int[] nums2) {

		MoveAllZeroesToEnd.printArray(nums, false);
		MoveAllZeroesToEnd.printArray(nums2, false);

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			set.add(nums2[i]);
		}
		System.out.println("Brute result ");

		for (int i : set) {
			System.out.print(i + " ");

		}
		System.out.println();

	}

	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 1, 1, 2, 3, 4, 5 };
		int[] arr2 = new int[] { 2, 3, 4, 4, 5, 6 };
		UnionOfSortedArrays.bruteForce(arr1, arr2);
		UnionOfSortedArrays.optimal(arr1, arr2);
	}

	public static void optimal(int[] nums1, int[] nums2) {
		System.out.println("Optimal..");
		UnionOfSortedArrays.printArray(nums1, false);
		UnionOfSortedArrays.printArray(nums2, false);

		List<Integer> answer = new ArrayList<>();

		int leftP = 0, rightP = 0;

		while (leftP < nums1.length && rightP < nums2.length) {
			if (nums1[leftP] < nums2[rightP]) {
				if (answer.size() == 0 || nums1[leftP] != answer.get(answer.size() - 1)) {
					answer.add(nums1[leftP]);
				}
				leftP++;
			} else {
				if (answer.size() == 0 || nums2[rightP] != answer.get(answer.size() - 1)) {
					answer.add(nums2[rightP]);
				}
				rightP++;
			}
		}

		while (leftP < nums1.length) {
			answer.add(nums1[leftP++]);
		}

		while (rightP < nums2.length) {
			answer.add(nums2[rightP++]);
		}


		System.out.println("Optimal result ");

		for (int a : answer) {
			System.out.print(a + " ");
		}

	}

	public static void printArray(int[] input, boolean after) {

		for (int i : input) {
			System.out.print(i + " ");
		}

		System.out.println();

		if (after) {
			System.out.println("----End of result----");
		}
	}

}
