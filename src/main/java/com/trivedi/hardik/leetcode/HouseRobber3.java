package com.trivedi.hardik.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house
 * has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically
 * contact the police if two directly-linked houses were broken into on the same
 * night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * 
 * https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
 * 
 * @author hatrivedi
 * @date Dec 6, 2018
 * @since 2.5
 */
public class HouseRobber3 {

	// Easy to understand solution
	public int rob(TreeNode root) {
		return helper(root, new HashMap<TreeNode, Integer>());
	}

	private int helper(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) {
			return 0;
		}
		if (map.containsKey(root)) {
			return map.get(root);
		}

		int val = root.val;

		if (root.left != null) {
			val += helper(root.left.left, map) + helper(root.left.right, map);
		}
		if (root.right != null) {
			val += helper(root.right.left, map) + helper(root.right.right, map);
		}

		int returnVal = Math.max(val, helper(root.left, map) + helper(root.right, map));
		map.put(root, returnVal);
		return returnVal;
	}

	// Optimized solution
	public int rob1(TreeNode root) {
		int res[] = helper(root);
		return Math.max(res[0], res[1]);
	}

	private int[] helper(TreeNode root) {
		if (root == null)
			return new int[2];
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		int[] result = new int[2];
		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		result[1] = root.val + left[0] + right[0];
		return result;
	}
}
