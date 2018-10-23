/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class SameTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	
	//Preorder traversal solution
	public boolean isSameTree(TreeNode p, TreeNode q) {
        System.out.println(inOrderTraversal(p, new ArrayList<Integer>()));
        System.out.println(inOrderTraversal(q, new ArrayList<Integer>()));
        return inOrderTraversal(p, new ArrayList<Integer>()).equals(inOrderTraversal(q, new ArrayList<Integer>()));
    }
    
    public List<Integer> inOrderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            list.add(null);
        } else {
            list.add(root.val);
            inOrderTraversal(root.left, list);
            inOrderTraversal(root.right, list);
        }
        return list;
    }
    
    
    
    //Simple Recursive solution
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
