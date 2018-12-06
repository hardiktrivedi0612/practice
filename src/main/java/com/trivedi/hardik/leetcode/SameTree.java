package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two binary trees, write a function to check if they are the same or
 * not.
 * 
 * Two binary trees are considered the same if they are structurally identical
 * and the nodes have the same value.
 * 
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class SameTree {

	// Preorder traversal solution
	public boolean isSameTree(TreeNode p, TreeNode q) {
		System.out.println(inOrderTraversal(p, new ArrayList<Integer>()));
		System.out.println(inOrderTraversal(q, new ArrayList<Integer>()));
		return inOrderTraversal(p, new ArrayList<Integer>()).equals(inOrderTraversal(q, new ArrayList<Integer>()));
	}

	public List<Integer> inOrderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			list.add(null);
		} else {
			list.add(root.val);
			inOrderTraversal(root.left, list);
			inOrderTraversal(root.right, list);
		}
		return list;
	}

	// Simple Recursive solution
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null || p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
