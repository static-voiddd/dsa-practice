package com.staticvoid.dsa.array.easy;

public class MoveAllZeroesToEnd {

	public static int[] bruteForce(int[] nums) {

		MoveAllZeroesToEnd.printArray(nums, false);

		int[] tempArr = new int[nums.length];

		int j = 0;
		for (int i : nums) {
			if (i != 0) {
				tempArr[j++] = i;
			}
		}

		for (int p = j + 1; p < tempArr.length; p++) {
			tempArr[p++] = 0;
		}

		MoveAllZeroesToEnd.printArray(tempArr, true);

		return tempArr;
	}

	public static void main(String[] args) {
		MoveAllZeroesToEnd.bruteForce(new int[] { 1, 0, 2, 0, 0, 3, 0, 4, 5, 0 });
		MoveAllZeroesToEnd.optimal(new int[] { 1, 0, 2, 0, 0, 3, 0, 4, 5, 0 });
	}

	public static int[] optimal(int[] nums) {
		System.out.println("Optimal..");
		MoveAllZeroesToEnd.printArray(nums, false);

		int leftP = 0;
		int rightP = 0;

		while (rightP < nums.length) {
			if (nums[rightP] != 0) {
				int temp = nums[leftP];
				nums[leftP++] = nums[rightP];
				nums[rightP] = temp;
			}
			rightP++;
		}
		MoveAllZeroesToEnd.printArray(nums, true);

		return nums;
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
