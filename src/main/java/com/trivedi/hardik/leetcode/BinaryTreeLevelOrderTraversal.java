package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * @author hatrivedi
 * @date Dec 5, 2018
 * @since 2.5
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> response = new ArrayList<>();
		levelOrderUtil(root, response, 0);
		return response;
	}

	private void levelOrderUtil(TreeNode root, List<List<Integer>> response, int level) {
		if (root == null) {
			return;
		}
		if (response.size() - 1 < level) {
			response.add(new ArrayList<Integer>());
		}
		response.get(level).add(root.val);
		levelOrderUtil(root.left, response, level + 1);
		levelOrderUtil(root.right, response, level + 1);
		return;
	}
}
