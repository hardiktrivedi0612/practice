package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 
 * @author hatrivedi
 * @date Dec 10, 2018
 * @since 2.5
 */
public class BottomLeftTreeValue {

	// My Solution
	public int findBottomLeftValue(TreeNode root) {
		List<List<Integer>> response = new ArrayList<>();
		dfs(root, response, 0);
		return response.get(response.size() - 1).get(0);
	}

	public void dfs(TreeNode root, List<List<Integer>> response, int depth) {
		if (root == null) {
			return;
		}
		if (response.size() - 1 < depth) {
			response.add(new ArrayList<Integer>());
		}
		dfs(root.left, response, depth + 1);
		response.get(depth).add(root.val);
		dfs(root.right, response, depth + 1);
	}

	// Better solution
	public int findLeftMostNode(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (root.right != null)
				queue.add(root.right);
			if (root.left != null)
				queue.add(root.left);
		}
		return root.val;
	}
}
