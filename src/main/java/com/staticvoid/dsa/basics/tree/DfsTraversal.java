package com.staticvoid.dsa.basics.tree;

import java.util.List;

import com.staticvoid.dsa.basics.tree.CustomTree.TreeNode;

public abstract class DfsTraversal {

	private CustomTree tree;

	DfsTraversal() {
		tree = new CustomTree();
	}

	public abstract List<Integer> dfsRecursive(TreeNode node, List<Integer> list);

	public CustomTree getTree() {
		return tree;
	}

	public void setTree(CustomTree tree) {
		this.tree = tree;
	}

	public abstract List<Integer> traverseTreeIterative();

	public abstract List<Integer> traverseTreeRecursive();

}
