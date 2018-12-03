package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * @author hatrivedi
 * @date Oct 27, 2018
 * @since 2.5
 */
public class BinaryTreeZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> response = new ArrayList<>();
		dfsTraversal(root, 0, response);
		return response;
	}

	public void dfsTraversal(TreeNode root, int depth, List<List<Integer>> response) {
		if (root == null)
			return;
		if (response.size() - 1 < depth) {
			response.add(new ArrayList<Integer>());
		}

		if (depth % 2 == 0) {
			response.get(depth).add(root.val);
		} else {
			response.get(depth).add(0, root.val);
		}

		dfsTraversal(root.left, depth + 1, response);
		dfsTraversal(root.right, depth + 1, response);

		return;
	}
}
