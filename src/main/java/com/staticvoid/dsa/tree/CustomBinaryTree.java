package com.staticvoid.dsa.tree;

import java.util.Scanner;

public class CustomBinaryTree {
	private static class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		CustomBinaryTree tree = new CustomBinaryTree();
		tree.insert(new Scanner(System.in));
		tree.display();
	}

	private Node root;

	public CustomBinaryTree() {

	}

	public void display() {
		display(root, " ");
	}

	private void display(Node node, String indent) {
		if (node == null) {
			return;
		}
		System.out.println(indent + node.value);
		display(node.left, indent + "\t");
		display(node.right, indent + "\t");

	}

	public void insert(Scanner scanner) {
		System.out.println("Enter the value for node ");
		int value = scanner.nextInt();
		root = new Node(value);
		populate(scanner, root);

	}

	private void populate(Scanner scanner, Node node) {
		System.out.println("Do you want to enter left of " + node.value);
		boolean left = scanner.nextBoolean();

		if (left) {
			System.out.println("Enter the value for left of " + node.value);
			int leftValue = scanner.nextInt();
			node.left = new Node(leftValue);
			populate(scanner, node.left);
		}

		System.out.println("Do you want to enter right of " + node.value);
		boolean right = scanner.nextBoolean();

		if (right) {
			System.out.println("Enter the value for right of " + node.value);
			int rightValue = scanner.nextInt();
			node.right = new Node(rightValue);
			populate(scanner, node.right);
		}

	}

}
