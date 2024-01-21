package com.staticvoid.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.staticvoid.dsa.tree.CustomTree.TreeNode;

/**
 *
 *
          0
        /   \
       2     5
      / \   / \
     3   6 4   9
    / \   /     \
   1   7 8       10
 */

public class DfsTreeTraversal {

	public static void main(String[] args) {
		DfsTreeTraversal dfs = new DfsTreeTraversal();

		System.out.println(dfs.preOrderRecursive(dfs.tree.rootNode));
		System.out.println(dfs.preOrderIterative(dfs.tree.rootNode));

		System.out.println(dfs.inOrderRecursive(dfs.tree.rootNode));
		System.out.println(dfs.inOrderIterative(dfs.tree.rootNode));

		System.out.println(dfs.postOrderRecursive(dfs.tree.rootNode));
		System.out.println(dfs.postOrderIterative(dfs.tree.rootNode));

	}

	private CustomTree tree;

	public DfsTreeTraversal() {
		tree = new CustomTree();
	}

	public List<Integer> inOrderDfsRecursive(TreeNode node, List<Integer> list) {
		if (node == null) {
			return list;
		}

		inOrderDfsRecursive(node.left, list);
		list.add(node.val);
		return inOrderDfsRecursive(node.right, list);

	}

	public List<Integer> inOrderIterative(TreeNode root) {
		System.out.println("Iterative Pre...");

		List<Integer> list = new ArrayList<>();
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<>();

		while (curr != null || !stack.isEmpty()) {
			// put all the left node on stack first
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.val);

			// start going through right node
			// continue right node's left flow again on next iteration
			curr = curr.right;
		}

		return list;

	}

	public List<Integer> inOrderRecursive(TreeNode root) {
		System.out.println("Recursive In...");

		return inOrderDfsRecursive(root, new ArrayList<>());

	}

	public List<Integer> postOrderDfsRecursive(TreeNode node, List<Integer> list) {
		if (node == null) {
			return list;
		}

		preOrderDfsRecursive(node.left, list);
		preOrderDfsRecursive(node.right, list);
		list.add(node.val);
		return list;

	}

	public List<Integer> postOrderIterative(TreeNode root) {
		System.out.println("Iterative Post...");

		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;

		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {

			}
		}

		return list;

	}

	public List<Integer> postOrderRecursive(TreeNode root) {
		System.out.println("Recursive Post...");

		return postOrderDfsRecursive(root, new ArrayList<>());

	}

	public List<Integer> preOrderDfsRecursive(TreeNode node, List<Integer> list) {
		if (node == null) {
			return list;
		}

		list.add(node.val);

		preOrderDfsRecursive(node.left, list);
		return preOrderDfsRecursive(node.right, list);

	}

	public List<Integer> preOrderIterative(TreeNode root) {
		System.out.println("Iterative Pre...");

		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			root = stack.pop();
			list.add(root.val);
			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}
		}

		return list;

	}

	public List<Integer> preOrderRecursive(TreeNode root) {
		System.out.println("Recursive Pre...");

		return preOrderDfsRecursive(root, new ArrayList<>());

	}

}
