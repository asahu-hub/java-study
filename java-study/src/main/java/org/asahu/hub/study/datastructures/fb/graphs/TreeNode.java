package org.asahu.hub.study.datastructures.fb.graphs;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "\nNode Value: " + this.val + " Left: " + this.left + " Right: " + this.right;
	}
}