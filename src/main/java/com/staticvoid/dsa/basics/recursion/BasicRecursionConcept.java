package com.staticvoid.dsa.basics.recursion;

public class BasicRecursionConcept {

	public static void main(String[] args) {
		BasicRecursionConcept n = new BasicRecursionConcept();
		n.print1ToNumber(10);
		System.out.println();
		n.printNumberTo1(10);
		System.out.println();
		System.out.println(n.sumOfFirstN(10, 0));
		System.out.println();
		System.out.println(n.sumOfFirstN(10));
		System.out.println("Factorial");
		System.out.println(n.factorialOfN(10));
		n.printArray(new int[] { 1, 3, 4, 6, 7 });
		int[] arr = n.reverseArray(new int[] { 1, 3, 4, 6, 7 }, 0, 4);

		n.printArray(arr);

		// 0 1 1 2 3 5 8 13
		System.out.println(n.fibonacci(4)); // 3
		System.out.println(n.fibonacci(7)); // 13
	}

	public int factorialOfN(int n) {

		if (n == 1) {
			return 1;
		}

		return n * factorialOfN(n - 1);
	}

	public int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public void print1ToNumber(int n) {

		if (n == 0) {
			return;
		}

		print1ToNumber(n - 1);
		System.out.print(n + " ");

	}

	public void printArray(int [] nums) {
		for (int i: nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void printNumberTo1(int n) {

		if (n == 0) {
			return;
		}

		System.out.print(n + " ");
		printNumberTo1(n - 1);

	}

	public int[] reverseArray(int[] nums, int left, int right) {

		if (left == right) {
			return nums;
		}
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;

		return reverseArray(nums, left + 1, right - 1);

	}

	public int sumOfFirstN(int n) {

		if (n < 0) {
			return 0;
		}

		return n + sumOfFirstN(n - 1);

	}

	public int sumOfFirstN(int n, int sum) {

		if (n < 0) {
			return sum;
		}

		return sumOfFirstN(n - 1, sum + n);

	}

}
