package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider all the leaves of a binary tree. From left to right order, the
 * values of those leaves form a leaf value sequence.
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 * 
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class LeafSimilarTrees {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		return getLeafSequence(root1, new ArrayList<Integer>())
				.equals(getLeafSequence(root2, new ArrayList<Integer>()));
	}

	public List<Integer> getLeafSequence(TreeNode root, ArrayList<Integer> leafSequence) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				leafSequence.add(root.val);
			} else {
				getLeafSequence(root.left, leafSequence);
				getLeafSequence(root.right, leafSequence);
			}
		}
		return leafSequence;
	}

}
