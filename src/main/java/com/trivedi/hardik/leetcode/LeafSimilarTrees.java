/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
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
        return getLeafSequence(root1, new ArrayList<Integer>()).equals(getLeafSequence(root2, new ArrayList<Integer>()));
    }
    
    public List<Integer> getLeafSequence(TreeNode root, ArrayList<Integer> leafSequence) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                leafSequence.add(root.val);
            } else {
                getLeafSequence(root.left, leafSequence);
                getLeafSequence(root.right, leafSequence);
            }
        }
        return leafSequence;
    }

}
