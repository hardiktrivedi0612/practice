package com.trivedi.hardik.leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hatrivedi
 * @date Oct 26, 2018
 * @since 2.5
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		return buildTreeInorderAndPostOrder(inorder, postorder, inorderMap, postorder.length - 1, 0,
				inorder.length - 1);

	}

	public TreeNode buildTreeInorderAndPostOrder(int[] inorder, int[] postorder, Map<Integer, Integer> inordermap,
			int postorderIndex, int inorderStartIndex, int inorderEndIndex) {
		if (postorderIndex < 0 || inorderStartIndex > inorderEndIndex) {
			return null;
		}

		TreeNode node = new TreeNode(postorder[postorderIndex]);

		if (inorderStartIndex == inorderEndIndex) {
			return node;
		}

		int inorderIndex = inordermap.get(node.val);

		node.left = buildTreeInorderAndPostOrder(inorder, postorder, inordermap,
				postorderIndex - (inorderEndIndex - inorderIndex) - 1, inorderStartIndex, inorderIndex - 1);
		node.right = buildTreeInorderAndPostOrder(inorder, postorder, inordermap, postorderIndex - 1, inorderIndex + 1,
				inorderEndIndex);

		return node;

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
		ConstructBinaryTreeFromInorderAndPostorder app = new ConstructBinaryTreeFromInorderAndPostorder();
		app.inOrderTraversal(app.buildTree(new int[] { 9,3,15,20,7 }, new int[] { 9,15,7,20,3 }));
	}

}
