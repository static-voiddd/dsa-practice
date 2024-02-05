package com.staticvoid.dsa.basics.math;

public class ArmStrongNumber {

	public static void main(String[] args) {
		ArmStrongNumber a = new ArmStrongNumber();
		System.out.println(a.isArmstrong(124));

	}

	public boolean isArmstrong(int n) {
		int length = 0;
		int temp = n;
		while (temp != 0) {
			length++;
			temp = temp / 10;
		}
		int original = n;
		int sum = 0;
		while (n != 0) {
			int lastD = n % 10;
			sum += Math.pow(lastD, length);
			n = n / 10;
		}

		return sum == original;
	}

}
