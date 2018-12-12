package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * READ:
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 * 
 * @author hatrivedi
 * @date Dec 11, 2018
 * @since 2.5
 */
public class Subsets2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> response = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(response, new ArrayList<Integer>(), nums, 0);
		return response;
	}

	private void backtrack(List<List<Integer>> response, ArrayList<Integer> tempList, int[] nums, int start) {
		response.add(new ArrayList<Integer>(tempList));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i - 1] == nums[i]) {
				// Skip duplicates
				continue;
			}
			tempList.add(nums[i]);
			backtrack(response, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
