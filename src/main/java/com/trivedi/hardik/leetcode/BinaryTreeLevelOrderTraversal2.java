package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * @author hatrivedi
 * @date Dec 8, 2018
 * @since 2.5
 */
public class BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> response = new ArrayList<>();
		helper(root, response, 0);
		return response;
	}

	public void helper(TreeNode root, List<List<Integer>> response, int level) {
		if (root == null) {
			return;
		}
		if (response.size() - 1 < level) {
			response.add(0, new ArrayList<Integer>());
		}
		helper(root.left, response, level + 1);
		helper(root.right, response, level + 1);
		response.get(response.size() - level - 1).add(root.val);
	}
}
