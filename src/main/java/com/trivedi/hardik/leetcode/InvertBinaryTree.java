package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Dec 5, 2018
 * @since 2.5
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		invertTreeUtil(root);
		return root;
	}

	public void invertTreeUtil(TreeNode root) {
		if (root == null) {
			return;
		}
		invertTreeUtil(root.left);
		invertTreeUtil(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
}
