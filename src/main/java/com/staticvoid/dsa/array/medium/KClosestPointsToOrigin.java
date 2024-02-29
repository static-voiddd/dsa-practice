package com.staticvoid.dsa.array.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {


	public static int[][] bruteForce(int[][] points, int K) {

		// O(NlogN) due to sorting
		// Space is O(1)
		Arrays.sort(points, (p1, p2) -> { // comparator
			return dis(p1) - dis(p2);
		});

		int[][] result = new int[K][];
		for (int i = 0; i < K; ++i) {
			result[i] = new int[] { points[i][0], points[i][1] };
		}

		KClosestPointsToOrigin.printArray(result);
		return result;

	}

	private static int dis(int[] p) { // square
		int sum = p[0] * p[0] + p[1] * p[1];
		System.out.println(p[0] + " " + p[1] + " " + "sum " + sum);
		return sum;
	}

	public static void main(String[] args) {
		int[][] points = new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		// KClosestPointsToOrigin.bruteForce(points, 2);
		KClosestPointsToOrigin.priorityQueue(points, 2);
		// KClosestPointsToOrigin.quickSort(points, 2);

	}

	public static void printArray(int[][] input) {

		for (int[] i : input) {
			System.out.print(i[0] + " " + i[1] + " ");
		}

		System.out.println("DONE");

	}

	// O(Nlogk) due to sorting
	// Space is O(k)

	public static int[][] priorityQueue(int[][] points, int k) {

		System.out.println("Priortiy Q");

		PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
			return dis(points[i2]) - dis(points[i1]);
		});

		// { 3, 3 }, { 5, -1 }
		// 9 + 9 , 18 and 26
		// 0 , 1 index 1 stays on top -> 1, 0

		// adding {-2, 4} for index 2 - diff is 4 + 16 = 20
		// while adding to q now we compare with {5,-1} top value of q i.e 26
		// so now we have 1, 0, 2 (sum 26, 18, 20) with highest on top

		// k loop and we remove 26 first hence
		// 2, 0 (20, 18) - left, high on top

		for (int i = 0; i < points.length; ++i) {

			// 18, 26, 20 difference
			// 0, 1 ,2
			// 20, 18, 26
			System.out.println("Going to add " + i);
			pq.add(i);
			System.out.println("Added i " + i);
			// when we add , its gonna add as per the comparator logic above

			// 26 index 1 is at top, 18 index 0 at bottom
			// we keep on adding with sorted value of the diff
			// high diff will be on top

			// we remove if we go beyond k so that only our answers will be there on q
			if (pq.size() > k) {
				System.out.println("Removed k  " + i);
				pq.remove();
			}
		}

		int[][] result = new int[k][];
		for (int i = 0; i < k; i++) {
			int indx = pq.remove();
			result[i] = points[indx];
		}

		KClosestPointsToOrigin.printArray(result);
		return result;

	}

	// find the k-th element (from 0 ~ hi - 1)
	private static void quickSelect(int[][] points, int k, int lo, int hi) {
		if (lo == hi) {
			return;
		}
		int randIdx = (hi - lo) / 2;
		// consider the mid as our pivot

		swap(points, lo, randIdx);
		int key = lo;
		int i = lo, j = hi + 1; // one index offset

		while (true) {
			while (dis(points[++i]) < dis(points[key])) { // move i
				if (i == hi) {
					break;
				}
			}
			while (dis(points[--j]) > dis(points[key])) { // move j
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			swap(points, i, j);
		}
		swap(points, key, j); // put [key] to the correct place [<key] [key] [>key]

		// notice that k = K - 1
		// j is now where [key] is
		if (j > k) {
			quickSelect(points, k, lo, j - 1); // left
		}
		if (j < k) {
			quickSelect(points, k, j + 1, hi); // right
			// if j == k, finish.
		}
	}

	public static int[][] quickSort(int[][] points, int K) {
		System.out.println("Inside sorting...");

		int n = points.length;
		quickSelect(points, K - 1, 0, n - 1); // index from 0
		int[][] result = new int[K][];
		for (int i = 0; i < K; ++i) {
			result[i] = points[i];
		}

		KClosestPointsToOrigin.printArray(result);
		return result;

	}

	private static void swap(int[][] points, int i, int j) {
		int[] temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}

}
