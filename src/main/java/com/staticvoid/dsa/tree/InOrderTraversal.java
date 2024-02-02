/**
 *
 */
package com.staticvoid.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.staticvoid.dsa.tree.CustomTree.TreeNode;

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

public class InOrderTraversal extends DfsTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DfsTraversal traversal = new InOrderTraversal();
		System.out.println(traversal.traverseTreeRecursive());
		System.out.println(traversal.traverseTreeIterative());
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
		if (getTree().rootNode == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = getTree().rootNode;

		while (true) {
			if (curr != null) {
				stack.push(curr); // first push left nodes till we meet null left node
				curr = curr.left;
			} else {
				if (stack.isEmpty()) { // if stack empty we know we are done traversing
					break;
				}
				curr = stack.pop(); // start poping last left once we hit null
				list.add(curr.val); // visit the poped node value
				curr = curr.right; // now right node goes to stack
			}
		}

		return list;
	}

	@Override
	public List<Integer> traverseTreeRecursive() {
		System.out.println("Printing DFS Pre recursive");
		return dfsRecursive(getTree().rootNode, new ArrayList<>());
	}

}
