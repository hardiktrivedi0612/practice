package com.trivedi.hardik.leetcode;

import java.util.HashMap;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class ContructBinaryTreeFromPreOrderAndInOrder {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// To not use map as a global variable. Instead pass it to methods
	HashMap<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTree(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode buildTree(int preOrderIndex, int inOrderStartIndex, int inOrderEndIndex, int[] preorder,
			int[] inorder) {
		if (inOrderStartIndex > inOrderEndIndex || preOrderIndex > preorder.length - 1) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preOrderIndex]);

		if (inOrderStartIndex == inOrderEndIndex) {
			return root;
		}

		int inOrderIndex = this.map.get(root.val);

		root.left = buildTree(preOrderIndex + 1, inOrderStartIndex, inOrderIndex - 1, preorder, inorder);
		root.right = buildTree(preOrderIndex + inOrderIndex - inOrderStartIndex + 1, inOrderIndex + 1, inOrderEndIndex,
				preorder, inorder);

		return root;

	}

	public void inOrderTraversal(TreeNode root) {
		if (root == null) {
			System.out.println("null");
		} else {
			System.out.println(root.val);
			inOrderTraversal(root.left);
			inOrderTraversal(root.right);
		}
	}

	public static void main(String[] args) {
		ContructBinaryTreeFromPreOrderAndInOrder app = new ContructBinaryTreeFromPreOrderAndInOrder();
		app.inOrderTraversal(app.buildTree(new int[] { 1, 2 }, new int[] { 1, 2 }));
	}

}
