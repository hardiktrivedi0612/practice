package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class Subsets {

	// Solution using bits
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		long powerSetSize = (long) Math.pow(2, nums.length);
		for (int counter = 0; counter < powerSetSize; counter++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if ((counter & (1 << j)) > 0) {
					subset.add(nums[j]);
				}
			}
			subsets.add(subset);
		}
		return subsets;
	}

	// Solution using Backtracking
	public List<List<Integer>> subsetsBT(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
