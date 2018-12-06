
package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class LowestCommonAncestorInBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
		TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);
		if (leftAncestor != null && rightAncestor != null) {
			// Ancestor is found
			return root;
		}
		return (leftAncestor == null) ? rightAncestor : leftAncestor;
	}
}
