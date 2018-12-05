package com.trivedi.hardik.leetcode.design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.trivedi.hardik.leetcode.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class SerializeDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preOrderSerialization(root, sb);
		return sb.toString();
	}

	private void preOrderSerialization(TreeNode root, StringBuilder preOrder) {
		if (root == null) {
			preOrder.append("null").append(",");
			return;
		}
		preOrder.append(root.val).append(",");
		preOrderSerialization(root.left, preOrder);
		preOrderSerialization(root.right, preOrder);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] nodes = data.split(",");
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(nodes));
		return treeDeserialize(queue);
	}

	private TreeNode treeDeserialize(Queue<String> queue) {
		String node = queue.remove();
		if (node.equals("null")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(node));
		root.left = treeDeserialize(queue);
		root.right = treeDeserialize(queue);
		return root;
	}
}
