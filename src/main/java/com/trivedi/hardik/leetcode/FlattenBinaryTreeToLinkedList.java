package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		flatten(left);
		flatten(right);
		root.left = null;
		root.right = left;
		TreeNode temp = root;
		while (temp.right != null) {
			temp = temp.right;
		}
		temp.right = right;
	}

	// Another cleaner solution
	TreeNode prev;

	public void flatten1(TreeNode root) {
		if (root == null) {
			return;
		}
		prev = null;
		preOrder(root);
	}

	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (prev != null) {
			prev.left = null;
			prev.right = root;
		}
		prev = root;
		preOrder(left);
		preOrder(right);
	}
}
