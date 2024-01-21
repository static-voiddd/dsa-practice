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

   <root> <left> <right>
   Pre-order DFS 0 2 3 1 7 6 5 4 8 9 10
   Stack for iterative - LIFO

   Space complexity - O(h), h is height of tree, worst case O(n)
   Time complexity - O(n), we visit every node once
 */

public class PreOrderTraversal implements DfsTraversal {

	public static void main(String[] args) {
		PreOrderTraversal traversal = new PreOrderTraversal();
		System.out.println(traversal.traverseTreeRecursive());
		System.out.println(traversal.traverseTreeIterative());
	}

	private CustomTree tree;

	public PreOrderTraversal() {
		tree = new CustomTree();
	}

	@Override
	public List<Integer> dfsRecursive(TreeNode node, List<Integer> list) {

		if (node == null) {
			return list;
		}

		//visit the root first
		list.add(node.val);
		//visit left node
		dfsRecursive(node.left, list);

		//once left is all done, visit right
		return dfsRecursive(node.right, list);
	}

	@Override
	public List<Integer> traverseTreeIterative() {
		System.out.println("Printing DFS Pre iterative");
		List<Integer> list = new ArrayList<>();
		if (tree.rootNode == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();

		//push the root node
		stack.push(tree.rootNode);

		while (!stack.isEmpty()) {
			TreeNode removedNode = stack.pop();
			list.add(removedNode.val);

			// first put right node
			// since on stack the last added pops out first
			// and we need left item to be removed at first

			if (removedNode.right != null) {
				stack.push(removedNode.right);
			}

			if (removedNode.left != null) {
				stack.push(removedNode.left);
			}
		}

		return list;
	}

	@Override
	public List<Integer> traverseTreeRecursive() {
		System.out.println("Printing DFS Pre recursive");
		//at first we pass our base root node and empty list
		return dfsRecursive(tree.rootNode, new ArrayList<>());
	}

}
