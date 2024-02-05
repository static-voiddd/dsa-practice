package com.staticvoid.dsa.basics.math;

public class CountNumberOfDigits {

	public static void main(String[] args) {
		CountNumberOfDigits c = new CountNumberOfDigits();
		c.countDigits(125);
		c.countDigits(12999);
		c.countDigits(0);
		c.countDigits(1);
		c.countDigits(-1);
		c.countDigits(-100);

	}

	public void countDigits(int n) {
		int original = n;
		int count = 0;
		if (n < 0) {
			n = -n;
		}

		if (n == 0) {
			System.out.println("Count of " + original + " is 1");
		}

		else {
			while (n > 0) {
				n = n / 10;
				count++;
			}

			System.out.println("Count of " + original + " is " + count);
		}

	}

}
