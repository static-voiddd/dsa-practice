package com.staticvoid.dsa.basics.math;

public class PrimeNumber {

	public static void main(String[] args) {
		PrimeNumber p = new PrimeNumber();
		p.calculate(10);
		p.calculate(2);
		p.calculate(1);
		p.calculate(17);
		p.calculate(26);
		p.calculate(36);

	}

	public void calculate(int n) {

		boolean isPrime = true;
		if (n == 1) {
			isPrime = false;
		}

		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}

		System.out.println("Number is Prime or not - " + n + isPrime);

	}

}
