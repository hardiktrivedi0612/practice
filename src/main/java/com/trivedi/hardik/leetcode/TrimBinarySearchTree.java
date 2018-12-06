package com.trivedi.hardik.leetcode;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L). You might
 * need to change the root of the tree, so the result should return the new root
 * of the trimmed binary search tree.
 * 
 * @author hatrivedi
 * @date Dec 5, 2018
 * @since 2.5
 */
public class TrimBinarySearchTree {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;
		if (root.val <= R && root.val >= L) {
			root.left = trimBST(root.left, L, root.val);
			root.right = trimBST(root.right, root.val, R);
			return root;
		} else if (root.val > R) {
			return trimBST(root.left, L, R);
		} else {
			return trimBST(root.right, L, R);
		}
	}
}
