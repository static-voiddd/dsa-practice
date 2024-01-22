package com.staticvoid.dsa.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.staticvoid.dsa.tree.CustomTree.TreeNode;

/**
          0
        /   \
       2     5
      / \   / \
     3   6 4   9
    / \   /     \
   1   7 8       10

   OP - [[0], [2, 5], [3, 6, 4, 9], [1, 7, 8, 10]]

   BFS visit - 0 2 5 3 6 4 9 1 7 8 10
 */

// Queue holds address of nodes which we have not visited yet

// 1. enqueue the parent
// 2. visit it and enqueue the children, remove parent from queue
// 3. visit left child, add its children, remove left and so on

// Time taken depends on number of nodes, complexity is O(n)
// Space complexity is O(1) at best, O(n) worst, hence O(n)

public class BfsTreeTraversal {

	public static void main(String[] args) {
		BfsTreeTraversal bfs = new BfsTreeTraversal();
		System.out.println(bfs.levelOrderTraversal());
		System.out.println(bfs.verticalOrderTraversal());
	}

	private CustomTree customBinaryTree;

	public BfsTreeTraversal() {
		customBinaryTree = new CustomTree();
	}

	public List<List<Integer>> levelOrderTraversal() {
		System.out.println("Printing for BFS level order ");

		List<List<Integer>> levels = new ArrayList<>();
		if (customBinaryTree.rootNode == null) {
			return levels;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		//initially add the root element
		queue.offer(customBinaryTree.rootNode);

		// root is level 0
		// this is needed because we have to add the list of node values to
		// proper index
		int treeLevel = 0;

		//while there is at least one discovered node but not visited
		while (!queue.isEmpty()) {
			int size = queue.size();
			levels.add(new ArrayList<Integer>());

			/**
			 * if we put 2 elements on queue before, we have to loop two times to go through
			 * their children hence for loop
			 */

			for (int i = 0; i< size; i++) {
				// take out first node
				TreeNode node = queue.poll();
				// now we visit that node and add its value
				levels.get(treeLevel).add(node.val);

				// add the left child to queue
				if (node.left != null) {
					queue.offer(node.left);
				}
				// add the right child to queue
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			treeLevel++;
		}

		return levels;
	}

	public List<List<Integer>> verticalOrderTraversal() {
		System.out.println("Printing for BFS vertical order ");
		List<List<Integer>> list = new ArrayList<>();
		if (customBinaryTree.rootNode == null) {
			return list;
		}

		// map storing column to the list of node values which lie on column value

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

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

}
