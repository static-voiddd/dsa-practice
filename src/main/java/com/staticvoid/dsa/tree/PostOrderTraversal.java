package com.staticvoid.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
          0
        /   \
       2     5
      / \   / \
     3   6 4   9
    / \   /     \
   1   7 8       10

Post DFS visit - 1 7 3 6 2 8 4 10 9 5 0
 */

//Time taken depends on number of nodes, complexity is O(n)

//Space complexity O(n)

import com.staticvoid.dsa.tree.CustomTree.TreeNode;

public class PostOrderTraversal implements DfsTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PostOrderTraversal traversal = new PostOrderTraversal();
		System.out.println(traversal.traverseTreeRecursive());
		System.out.println(traversal.traverseTreeIterativeTwoStacks());
		System.out.println(traversal.traverseTreeIterative());
	}

	private CustomTree tree;

	public PostOrderTraversal() {
		tree = new CustomTree();
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

		if (tree.rootNode == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = tree.rootNode;

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

		if (tree.rootNode == null) {
			return list;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		TreeNode curr = tree.rootNode;
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
		return dfsRecursive(tree.rootNode, new ArrayList<>());
	}

}
