package com.staticvoid.dsa.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import com.staticvoid.dsa.tree.CustomTree.TreeNode;

public class VerticalOrderTreeTraversal extends BfsTreeTraversal {

	public static class Tuple {
		private TreeNode node;
		private int x;
		private int y;

		public Tuple(int x, int y, TreeNode node) {
			this.x = x;
			this.y = y;
			this.node = node;
		}
	}

	public static void main(String[] args) {
		VerticalOrderTreeTraversal bfs = new VerticalOrderTreeTraversal();
		System.out.println(bfs.verticalOrderTraversal());
		System.out.println(bfs.verticalOrderTraversalSorted());
	}

	// LC 314 Medium
	public List<List<Integer>> verticalOrderTraversal() {
		System.out.println("Printing for BFS vertical order ");
		List<List<Integer>> list = new ArrayList<>();
		if (customBinaryTree.rootNode == null) {
			return list;
		}

		// map storing column to the list of node values which lie on column value

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		// keep map of node to column

		Map<TreeNode, Integer> nodeToColumn = new HashMap<>();

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(customBinaryTree.rootNode);
		nodeToColumn.put(customBinaryTree.rootNode, 0);
		int minimumCol = 0;

		while (!queue.isEmpty()) {
			TreeNode removed = queue.poll();
			int column = nodeToColumn.get(removed);

			if (!map.containsKey(column)) {
				map.put(column, new ArrayList<Integer>());
			}

			map.get(column).add(removed.val);

			if (removed.left != null) {
				queue.offer(removed.left);
				nodeToColumn.put(removed.left, column - 1);
			}

			if (removed.right != null) {
				queue.offer(removed.right);
				nodeToColumn.put(removed.right, column + 1);
			}

			minimumCol = Math.min(minimumCol, column);
		}

		while (map.containsKey(minimumCol)) {
			list.add(map.get(minimumCol++));
		}

		return list;

	}

	// LC 987 HARD
	public List<List<Integer>> verticalOrderTraversalSorted() {
		System.out.println("Printing for BFS vertical order sorted ");
		List<List<Integer>> list = new ArrayList<>();

		// x value(key of TreeMap, is sorted), <yvalue - [node value sorted]- PriorityQ
		// 1 : (1, [2,4]
		// 2: (2, [1,4]

		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

		Queue<Tuple> queue = new LinkedList<>();

		// add first node with 0, 0 as x and y
		queue.offer(new Tuple(0, 0, customBinaryTree.rootNode));

		while (!queue.isEmpty()) {
			Tuple removed = queue.poll();
			int x = removed.x;
			int y = removed.y;

			// if map has the x coordinate key or not

			if (!map.containsKey(x)) {
				map.put(x, new TreeMap<>());
			}

			// if x coordinate key had a value <yvalue, node> with yvalue as key
			if (!map.get(x).containsKey(y)) {
				map.get(x).put(y, new PriorityQueue<>());
			}

			map.get(x).get(y).add(removed.node.val);

			if (removed.node.left != null) {
				queue.offer(new Tuple(x - 1, y + 1, removed.node.left));
			}

			if (removed.node.right != null) {
				queue.offer(new Tuple(x + 1, y + 1, removed.node.right));
			}
		}

		// create the list
		for (TreeMap<Integer, PriorityQueue<Integer>> combo : map.values()) {
			// Create a sublist to store node values in each vertical.
			list.add(new ArrayList<>());

			for (PriorityQueue<Integer> nodes : combo.values()) {

				while (!nodes.isEmpty()) {
					list.get(list.size() - 1).add(nodes.poll());
				}

			}

		}

		return list;

	}

}
