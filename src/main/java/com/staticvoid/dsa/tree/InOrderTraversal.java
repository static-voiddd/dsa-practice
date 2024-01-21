/**
 *
 */
package com.staticvoid.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*-
          0
        /   \
       2     5
      / \   / \
     3   6 4   9
    / \   /     \
   1   7 8       10

<left> <root> <right>
In -order DFS 1 3 7 2 6 0 8 4 5 9 10
Stack for iterative - LIFO

Space complexity - O(h), h is height of tree, worst case O(n)
Time complexity - O(n), we visit every node once
 */

public class InOrderTraversal implements DfsTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InOrderTraversal traversal = new InOrderTraversal();
		System.out.println(traversal.traverseTreeRecursive());
		System.out.println(traversal.traverseTreeIterative());
	}

	private CustomTree tree;

	public InOrderTraversal() {
		tree = new CustomTree();
	}

	@Override
	public List<Integer> dfsRecursive(TreeNode node, List<Integer> list) {

		if (node == null) {
			return list;
		}

		dfsRecursive(node.left, list);
		list.add(node.val);
		dfsRecursive(node.right, list);

		return list;
	}

	@Override
	public List<Integer> traverseTreeIterative() {
		System.out.println("Printing DFS Pre iterative");

		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode curr = tree.rootNode;

		while (curr != null) {
			// put the root element
			stack.push(curr);
			if (curr.left != null) {
				stack.push(curr.left);
				curr = curr.left;
			}
		}

		TreeNode removed = stack.pop();
		list.add(removed.val);

		curr = removed.right;

		return list;
	}

	@Override
	public List<Integer> traverseTreeRecursive() {
		System.out.println("Printing DFS Pre recursive");
		return dfsRecursive(tree.rootNode, new ArrayList<>());
	}

}
