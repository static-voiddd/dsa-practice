package com.staticvoid.dsa.basics;


public class Patterns {

	public static void main(String[] args) {
		Patterns patterns = new Patterns();
		patterns.printNByN(6);
		patterns.printRightAngled(6);
		patterns.printNTriangle(6);
		patterns.printNRepeatTriangle(6);
		patterns.printInvertedRightPyramid(6);
		patterns.printInvertedNRightPyramid(6);
	}


	/**
	 1 2 3 4 5 6
	 1 2 3 4 5
	 1 2 3 4
	 1 2 3
	 1 2
	 1
	 */
	public void printInvertedNRightPyramid(int n) {
		System.out.println("Inverted right N pyramid");
		for (int i = n; i > 0 ; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

	/**
	 *****
	 ****
	 ***
	 **
	 *
	 */
	public void printInvertedRightPyramid(int n) {
		System.out.println("Inverted right pyramid");
		for (int i = n; i > 0 ; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print('*' + " ");
			}
			System.out.println();
		}

	}

	/**
	 *****
	 *****
	 *****
	 *****
	 *****
	 */

	public void printNByN(int n) {
		System.out.println("N by N");
		for (int i = 0; i<n ; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print('*' + " ");
			}
			System.out.println();
		}
	}

	/*-
	 1
	 2 2
	 3 3 3
	 4 4 4 4
	 5 5 5 5 5
	 6 6 6 6 6 6
	 */
	public void printNRepeatTriangle(int n) {
		System.out.println("N Repeat Triangle");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	/*-
	 1
	 1 2
	 1 2 3
	 1 2 3 4
	 1 2 3 4 5
	 1 2 3 4 5 6
	 */
	public void printNTriangle(int n) {
		System.out.println("N Triangle");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	/**
	 *
	 **
	 ***
	 ****
	 *****
	 */
	public void printRightAngled(int n) {
		System.out.println("Right Angled");
		for (int i = 0; i<n ; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print('*' + " ");
			}
			System.out.println();
		}

	}

	/*-
	 *     
    ***    
   *****   
  *******  
 ********* 
***********
	 */
	public void printStarPyramid(int n) {
		System.out.println("Star pyramid");
		for (int i = n; i > 0 ; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print('*' + " ");
			}
			System.out.println();
		}

	}

}
