package com.staticvoid.dsa.basics.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * a. Start by putting any one of the graph's vertices at the back of a queue.
 *
 * b. Take the front item of the queue and add it to the visited list.
 *
 * c. Create a list of that vertex's adjacent nodes. Add the ones which aren't
 * in the visited list to the back of the queue.
 *
 * d. Keep repeating steps 2 and 3 until the queue is empty.
 *
 *
 *         0
        /    \
       1  __   2
       |       |
       3  __   4

 */
public class BfsTraversalGraph {

	// O(N) space complexity
	// O(N) time complexity - O(N) + O(2E)
	public static List<Integer> listBfsBasics(int v, List<List<Integer>> adj) {

		List<Integer> bfs = new ArrayList<>();
		boolean visited[] = new boolean[v];
		Queue<Integer> q = new LinkedList<>();

		q.add(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			int node = q.poll();
			bfs.add(node);

			// get all adjacent items of that node

			for (int adjacent : adj.get(node)) {
				if (!visited[adjacent]) {
					visited[adjacent] = true;
					q.add(adjacent);
				}
			}
		}
		return bfs;

	}

	public static void main(String[] args) {
		CustomAdjacentGraph g = new CustomAdjacentGraph();

		BfsTraversalGraph.printBfs(0, g);
		BfsTraversalGraph.printBfs(2, g);
	}

	public static void printBfs(int source, CustomAdjacentGraph graph) {
		System.out.println("Following is BFS starting from vertex " + source);

		boolean[] visited = new boolean[graph.getNumberOfVertices()];
		Queue<Integer> queue = new LinkedList<>();

		visited[source] = true;
		queue.add(source);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node);
			// System.out.print("-->");

			for (int n : graph.getAdjacentList().get(node)) {
				if (!visited[n]) {
					// System.out.print(n);
					// System.out.print(",");
					visited[n] = true;
					queue.add(n);
				}
			}
			System.out.println();
		}

	}


}
