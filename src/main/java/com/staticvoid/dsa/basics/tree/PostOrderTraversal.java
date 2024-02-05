package com.staticvoid.dsa.basics.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.staticvoid.dsa.basics.tree.CustomTree.TreeNode;

public class PostOrderTraversal extends DfsTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PostOrderTraversal traversal = new PostOrderTraversal();
		System.out.println(traversal.traverseTreeRecursive());
		System.out.println(traversal.traverseTreeIterativeTwoStacks());
		System.out.println(traversal.traverseTreeIterative());
	}


	@Override
	public List<Integer> dfsRecursive(TreeNode node, List<Integer> list) {
		if (node == null) {
			return list;
		}

		dfsRecursive(node.left, list);
		dfsRecursive(node.right, list);
		list.add(node.val);

		return list;
	}

	@Override
	public List<Integer> traverseTreeIterative() {
		System.out.println("Printing DFS Post iterative one stack");
		List<Integer> list = new ArrayList<>();

		if (getTree().rootNode == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = getTree().rootNode;

		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				curr = stack.push(curr);
				curr = curr.left;
			}

			else {
				TreeNode temp = stack.peek().right;
				if (temp == null) {
					temp = stack.pop();
					list.add(temp.val);
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						list.add(temp.val);
					}
				}
				else {
					curr = temp;
				}
			}
		}
		return list;

	}

	public List<Integer> traverseTreeIterativeTwoStacks() {
		System.out.println("Printing DFS Post iterative two stacks");
		List<Integer> list = new ArrayList<>();

		if (getTree().rootNode == null) {
			return list;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		TreeNode curr = getTree().rootNode;
		stack1.push(curr);

		while (!stack1.isEmpty()) {
			curr = stack1.pop();
			stack2.push(curr);

			if (curr.left != null) {
				stack1.push(curr.left);
			}
			if (curr.right != null) {
				stack1.push(curr.right);
			}
		}

		while (!stack2.isEmpty()) {
			curr = stack2.pop();
			list.add(curr.val);
		}
		return list;
	}


	@Override
	public List<Integer> traverseTreeRecursive() {
		System.out.println("Printing DFS Post recursive");
		return dfsRecursive(getTree().rootNode, new ArrayList<>());
	}

}
