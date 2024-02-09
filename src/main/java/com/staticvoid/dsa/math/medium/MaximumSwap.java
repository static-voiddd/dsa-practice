package com.staticvoid.dsa.math.medium;

public class MaximumSwap {

	/*
	 * Input: 2736 | Output: 7236, Input: 9973| Output: 9973, Input: 98368 | Output:
	 * 98863
	 *
	 * 1. Brute Force -
	 * a. Convert number to string array
	 * b. For each element we
	 * loop through all others, keep track of max.
	 * c. Swap and check if we found >
	 * existing max
	 * d. Revert the swap and continue the loop
	 *
	 * 2. Optimal - Greedy approach - start with four variables, l,r,maxInd,maxDigit
	 * a. From back side at each index, keep track of maxIndex and maxDigit so far
	 * b. On same loop, if we find item less than current maxDigit then we know we
	 * found potential left index, our right index will be maxDigit at this point
	 * c. Edge case, if given num is the max like 9973 we have to return same, at this
	 * point our l value will be -1 which is our original initialize value
	 * d. Edge case, if digit is same as maxdigit we do not do anything on that iteration
	 * e. By the end we know the left and right position to swap
	 */

	public static int bruteForce(int num) {
		// converting the number to the string
		char[] arr = String.valueOf(num).toCharArray();
		int max = num;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				char originalJ = arr[j];
				char originalI = arr[i];
				arr[j] = originalI;
				arr[i] = originalJ;

				max = Math.max(Integer.parseInt(new String(arr)), max);

				// revert the swap
				arr[j] = originalJ;
				arr[i] = originalI;

			}
		}
		return max;

	}

	public static void main(String[] args) {
		System.out.println(MaximumSwap.bruteForce(9973));
		System.out.println(MaximumSwap.bruteForce(2736));
		System.out.println(MaximumSwap.bruteForce(9999));
		System.out.println(MaximumSwap.bruteForce(98368));
		System.out.println("Optimal...");
		System.out.println(MaximumSwap.maximumSwap(9973));
		System.out.println(MaximumSwap.maximumSwap(2736));
		System.out.println(MaximumSwap.maximumSwap(9999));
		System.out.println(MaximumSwap.maximumSwap(98368));
	}

	public static int maximumSwap(int num) {
		if (num < 10) {
			return num;
		}
		int maxDigit = -1, maxIndex = -1;
		int leftIndex = -1, rightIndex = 1;

		char[] arr = String.valueOf(num).toCharArray();

		// find max from right
		for (int i = arr.length - 1; i >= 0; i--) {
			int currentDigit = Character.getNumericValue(arr[i]);
			if (currentDigit > maxDigit) {
				maxIndex = i;
				maxDigit = currentDigit;
			}

			// best digit for swap if there is no more
			// such situation on the left side
			else if (currentDigit < maxDigit) {
				leftIndex = i;
				rightIndex = maxIndex;
			}
		}

		// check for if number already in order
		if (leftIndex == -1) {
			return num;
		}

		char temp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = temp;

		return Integer.parseInt(new String(arr));
	}

}
