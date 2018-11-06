package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 31, 2018
 * @since 2.5
 */
public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		return (leftDepth == 0 || rightDepth == 0) ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
	}
}
