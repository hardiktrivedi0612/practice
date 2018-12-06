package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * @author hatrivedi
 * @date Dec 6, 2018
 * @since 2.5
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> response = new ArrayList<>();
		binaryTreePaths(root, null, response);
		return response;
	}

	public void binaryTreePaths(TreeNode root, String prefix, List<String> response) {
		if (root == null) {
			return;
		}
		String newPrefix = (prefix == null) ? "" + root.val : prefix + "->" + root.val;
		if (root.left == null && root.right == null) {
			response.add(newPrefix);
			return;
		}
		binaryTreePaths(root.left, newPrefix, response);
		binaryTreePaths(root.right, newPrefix, response);
	}
}
