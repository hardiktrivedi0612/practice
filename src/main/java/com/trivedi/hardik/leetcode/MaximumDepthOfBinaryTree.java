package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
		}
	}
}
