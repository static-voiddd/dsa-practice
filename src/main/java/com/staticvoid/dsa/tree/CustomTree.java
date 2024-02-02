package com.staticvoid.dsa.tree;

import java.util.Arrays;
import java.util.List;

public class CustomTree {

	public static class TreeNode {
		protected int val;
		protected TreeNode left;
		protected TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	private List<Integer> values = Arrays.asList(0, 2, 5, 3, 6, 4, 8, 9, 10, 1, 7);

	protected TreeNode rootNode;

	public CustomTree() {
		rootNode = new TreeNode(values.get(0));
		rootNode.left = new TreeNode(values.get(1));
		rootNode.right = new TreeNode(values.get(2));
		rootNode.left.left = new TreeNode(values.get(3));
		rootNode.left.right = new TreeNode(values.get(4));
		rootNode.right.left = new TreeNode(values.get(5));
		rootNode.right.left.left = new TreeNode(values.get(6));
		rootNode.right.right = new TreeNode(values.get(7));
		rootNode.right.right.right = new TreeNode(values.get(8));
		rootNode.left.left.left = new TreeNode(values.get(9));
		rootNode.left.left.right = new TreeNode(values.get(01));

		printTree();
	}

	private void printTree() {
		System.out.print("Original - ");

		for (int value : values) {
			System.out.print(value + " ");
		}

		System.out.println("");
		System.out.println("---------------------");

	}


}
