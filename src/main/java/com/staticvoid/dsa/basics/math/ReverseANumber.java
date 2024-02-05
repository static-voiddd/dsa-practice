package com.staticvoid.dsa.basics.math;

public class ReverseANumber {

	public static void main(String[] args) {
		ReverseANumber c = new ReverseANumber();
		c.reverse(321); // 123
		c.reverse(123);
		c.reverse(-123);
		c.reverse(1000000002);
		c.reverse(1000000003);

	}

	/*
	 * reverse1 does not handle reverse of 1000000003 which overflows
	 */

	public void reverse(int n) {
		int original = n;
		int answer = 0;
		while (n != 0) {
			int lastD = n % 10;
			// for 1000000003 last iteration we will have 300000000 as result
			// but our newresult will be some random number due to overflow
			int newResult = answer * 10 + lastD;
			// hence if we reverse what we did above we dont get old answer at this step
			if ((newResult - lastD) / 10 != answer) {
				answer = 0;
				break;
			}

			answer = newResult;
			n = n / 10;
		}
		System.out.println("Answer of " + original + " is " + answer);

	}

	public void reverse1(int n) {
		int original = n;
		int answer = 0;
		while (n != 0) {
			int lastD = n % 10;
			answer = answer * 10 + lastD;
			n = n / 10;
		}
		System.out.println("Answer of " + original + " is " + answer);

	}

}
