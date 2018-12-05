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
}
