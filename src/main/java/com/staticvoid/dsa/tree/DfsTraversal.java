package com.staticvoid.dsa.tree;

import java.util.List;

public interface DfsTraversal {
	
	public List<Integer> traverseTreeRecursive();
	
	public List<Integer> traverseTreeIterative();
	
	public List<Integer> dfsRecursive(TreeNode node, List<Integer> list);

}
