package org.asahu.hub.study.datastructures.fb.graphs;

public class BinarySearchTree_FB {

	/**
	 * Given the root of a binary tree, determine if it is a valid binary search
	 * tree (BST).
	 * 
	 * A valid BST is defined as follows:
	 * 
	 * 1. The left subtree of a node contains only nodes with keys less than the
	 * node's key. <br />
	 * 2. The right subtree of a node contains only nodes with keys greater than the
	 * node's key. <br/>
	 * 3. Both the left and right subtrees must also be binary search trees.
	 * 
	 */
	public boolean isValidBST(TreeNode root) {

		if (root.left == null && root.right == null) {
			return Boolean.TRUE;
		}
		int rootValue = root.val;
		int leftNodeValue = root.left.val;
		int rightNodeValue = root.right.val;

		if (rootValue > leftNodeValue && rootValue < rightNodeValue) {
			if (root.left != null && root.right == null) {
				return isValidBST(root.left);
			} else if (root.left == null && root.right != null) {
				return isValidBST(root.right);
			} else {
				return isValidBST(root.left) && isValidBST(root.right);
			}
		}
		return Boolean.FALSE;
	} // End isValidBST

	public TreeNode fromArray(Integer[] data) {
		TreeNode rootNode = new TreeNode();

		return rootNode;
	}

}
