/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class MaximumDepthOfNAryTree {

	// Recursive solution
	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		} else if (root.children == null || root.children.isEmpty()) {
			return 1;
		} else {
			List<Integer> childDepths = new ArrayList<>();
			for (Node child : root.children) {
				childDepths.add(maxDepth(child));
			}
			return Collections.max(childDepths) + 1;
		}
	}

	// Iterative solution
	public int maxDepth2(Node root) {
		if (root == null) {
			return 0;
		}
		int max = 1;
		for (Node child : root.children) {
			max = Math.max(maxDepth(child) + 1, max);
		}
		return max;
	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
