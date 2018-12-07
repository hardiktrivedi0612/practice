package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * @author hatrivedi
 * @date Dec 6, 2018
 * @since 2.5
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> response = new ArrayList<>();
		helper(root, 0, response);
		return response;
	}

	private void helper(TreeNode root, int depth, List<Integer> response) {
		if (root == null) {
			return;
		}
		if (response.size() == depth) {
			response.add(root.val);
		} else {
			response.set(depth, root.val);
		}
		helper(root.left, depth + 1, response);
		helper(root.right, depth + 1, response);
	}
}
