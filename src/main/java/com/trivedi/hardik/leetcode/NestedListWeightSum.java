package com.trivedi.hardik.leetcode;

import java.util.List;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	public int depthSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger i : nestedList) {
			if (i.isInteger()) {
				sum += i.getInteger() * depth;
			} else {
				sum += depthSum(i.getList(), depth + 1);
			}
		}
		return sum;
	}

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value);

		// Set this NestedInteger to hold a nested list and adds a nested
		// integer to it.
		public void add(NestedInteger ni);

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}
