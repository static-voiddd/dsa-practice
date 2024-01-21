package com.staticvoid.dsa.tree;

import java.util.Scanner;

public class CustomTree {
	
	protected TreeNode rootNode;
	
	public CustomTree() {
		rootNode = new TreeNode(0);
		rootNode.left = new TreeNode(2);
		rootNode.right = new TreeNode(5);
		rootNode.left.left = new TreeNode(3);
		rootNode.left.right = new TreeNode(6);
		rootNode.right.left = new TreeNode(4);
		rootNode.right.left.left = new TreeNode(8);
		rootNode.right.right = new TreeNode(9);
		rootNode.right.right.right = new TreeNode(10);
		rootNode.left.left.left = new TreeNode(1);
		rootNode.left.left.right = new TreeNode(7);
	}

	public static void main(String[] args) {
		CustomTree tree = new CustomTree();
		tree.insert(new Scanner(System.in));
		tree.display();
	}

	private TreeNode root;


	public void display() {
		display(root, " ");
	}

	private void display(TreeNode node, String indent) {
		if (node == null) {
			return;
		}
		System.out.println(indent + node.val);
		display(node.left, indent + "\t");
		display(node.right, indent + "\t");

	}

	public void insert(Scanner scanner) {
		System.out.println("Enter the value for node ");
		int value = scanner.nextInt();
		root = new TreeNode(value);
		populate(scanner, root);

	}

	private void populate(Scanner scanner, TreeNode node) {
		System.out.println("Do you want to enter left of " + node.val);
		boolean left = scanner.nextBoolean();

		if (left) {
			System.out.println("Enter the value for left of " + node.val);
			int leftValue = scanner.nextInt();
			node.left = new TreeNode(leftValue);
			populate(scanner, node.left);
		}

		System.out.println("Do you want to enter right of " + node.val);
		boolean right = scanner.nextBoolean();

		if (right) {
			System.out.println("Enter the value for right of " + node.val);
			int rightValue = scanner.nextInt();
			node.right = new TreeNode(rightValue);
			populate(scanner, node.right);
		}

	}

}
