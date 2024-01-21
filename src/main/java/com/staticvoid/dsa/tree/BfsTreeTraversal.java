package com.staticvoid.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	
	private CustomTree customBinaryTree;
	
	
	public BfsTreeTraversal() {
		customBinaryTree = new CustomTree();
	}
	
	public List<List<Integer>> levelOrderTraversal(TreeNode root) {
		System.out.println("Printing for BFS level order ");
		
		List<List<Integer>> levels = new ArrayList<>();
		if (root == null) return levels;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		//initially add the root element
	    queue.offer(root);
		
	    // root is level 0
	    // this is needed because we have to add the list of node values to 
	    // proper index
		int treeLevel = 0;
		
		//while there is at least one discovered node but not visited
		while (!queue.isEmpty()) {
			int size = queue.size();
			levels.add(new ArrayList<Integer>());
			
			 /** if we put 2 elements on queue before,
			 we have to loop two times to go through their children
			 */
			
			for (int i = 0; i< size; i++) { 
				// we just see the first element of queue, do not remove yet
				TreeNode node = queue.peek();
				//now we visit the node and add its value
				levels.get(treeLevel).add(node.val);
				
				// add the left child to queue
				if (node.left != null) {
					queue.offer(node.left);
				}
				// add the right child to queue
				if (node.right != null) {
					queue.offer(node.right);
				}
				// now remove the node from queue
				queue.poll();
			}
			treeLevel++;
		}
		
		return levels;
	}

	public static void main(String[] args) {
		BfsTreeTraversal bfs = new BfsTreeTraversal();
		System.out.println(bfs.levelOrderTraversal(bfs.customBinaryTree.node));

	}

}
