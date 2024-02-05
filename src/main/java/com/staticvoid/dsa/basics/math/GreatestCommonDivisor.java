package com.staticvoid.dsa.basics.math;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		GreatestCommonDivisor gcd = new GreatestCommonDivisor();
		gcd.calculate(9, 12);
		gcd.calculate(13, 7);
		gcd.calculate(4, 8);
		gcd.calculate(3, 6);
	}

	public void calculate(int num1, int num2) {

		int ans = 1;
		for (int i = 1; i <= Math.min(num1, num2); i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				ans = i;
			}
		}
		System.out.println("GCD of " + num1 + " " + num2 + " is " + ans);

		System.out.println(
				"GCD of " + num1 + " " + num2 + " is " + calculateEuclideanBad(num1, num2));

		System.out.println("GCD of 2nd e " + num1 + " " + num2 + " is " + calculateEuclidean(num1, num2));
	}

	// GCD of (a,b) = GCD(a %b, b) where a > b
	public int calculateEuclidean(int num1, int num2) {

		if (num1 == 0) {
			return num2;
		}

		int diff = num1 > num2 ? num1 % num2 : num2 % num1;

		return calculateEuclidean(diff, Math.min(num1, num2));

	}

	public int calculateEuclideanBad(int num1, int num2) {

		if (num1 == 0) {
			return num2;
		}

		int diff = num1 > num2 ? num1 - num2 : num2 - num1;

		return calculateEuclideanBad(diff, Math.min(num1, num2));

	}

}
