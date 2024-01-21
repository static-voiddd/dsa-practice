package com.staticvoid.dsa.tree;

import java.util.List;

import com.staticvoid.dsa.tree.CustomTree.TreeNode;

public interface DfsTraversal {

	public List<Integer> dfsRecursive(TreeNode node, List<Integer> list);

	public List<Integer> traverseTreeIterative();

	public List<Integer> traverseTreeRecursive();

}
