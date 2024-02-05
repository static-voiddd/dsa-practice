package com.staticvoid.dsa.basics.math;

public class Divisors {

	public static void main(String[] args) {
		Divisors div = new Divisors();
		div.calculate(36);
		div.calculate(97);
		div.calculateOptimal(36);
		div.calculateOptimal(97);
	}

	/* Brute Force where TC is O(n) */

	public void calculate(int n) {
		int i = 1;
		System.out.println("Number " + n);
		while (i <= n) {
			if (n % i == 0) {
				System.out.println(i);
			}
			i++;

		}
	}

	/* Optimal where TC is O(sqroot(n)) */
	public void calculateOptimal(int n) {
		int i = 1;
		System.out.println("Optimal - Number " + n);
		while (i <= (int) Math.sqrt(n)) {
			if (n % i == 0) {
				System.out.println(i);
				if (i != n / i) {
					System.out.println(n / i);
				}
			}
			i++;

		}
	}


}
