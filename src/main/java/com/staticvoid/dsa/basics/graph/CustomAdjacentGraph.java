package com.staticvoid.dsa.basics.graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *         0
       /    \
      1  __   2
      |       |
      3  __   4

 */

public class CustomAdjacentGraph {

	private int numberOfVertices;
	private List<List<Integer>> adjacentList;

	public CustomAdjacentGraph() {
		this(5);
	}

	public CustomAdjacentGraph(int v) {
		numberOfVertices = v;
		adjacentList = new ArrayList<>();

		for (int i = 0; i < v; i++) {
			adjacentList.add(new ArrayList<>());
		}

		addEdge(0, 1);
		addEdge(1, 0);
		addEdge(0, 2);
		addEdge(2, 0);
		addEdge(1, 2);
		addEdge(2, 1);

		addEdge(1, 3);
		addEdge(3, 1);

		addEdge(3, 4);
		addEdge(4, 3);

		addEdge(2, 4);
		addEdge(4, 2);
	}

	public CustomAdjacentGraph(int v, boolean custom) {
		numberOfVertices = v;
		adjacentList = new ArrayList<>();

		for (int i = 0; i < v; i++) {
			adjacentList.add(new ArrayList<>());
		}

		addEdge(1, 2);
		addEdge(2, 1);
		addEdge(2, 3);
		addEdge(3, 2);
		addEdge(2, 7);
		addEdge(7, 2);

		addEdge(3, 5);
		addEdge(5, 3);

		addEdge(7, 5);
		addEdge(5, 7);

	}

	public void addEdge(int v, int w) {
		adjacentList.get(v).add(w);

	}

	public List<List<Integer>> getAdjacentList() {
		return adjacentList;
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public void setAdjacentList(List<List<Integer>> adjacentList) {
		this.adjacentList = adjacentList;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

}
