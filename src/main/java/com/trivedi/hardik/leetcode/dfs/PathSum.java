package com.trivedi.hardik.leetcode.dfs;

import com.trivedi.hardik.leetcode.TreeNode;

/**
 * @author hatrivedi
 * @date Nov 5, 2018
 * @since 2.5
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
