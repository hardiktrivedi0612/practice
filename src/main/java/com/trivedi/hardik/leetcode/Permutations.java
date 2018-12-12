package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * @author hatrivedi
 * @date Dec 11, 2018
 * @since 2.5
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> allPermutations = new ArrayList<>();
		permute(allPermutations, new ArrayList<>(), nums);
		return allPermutations;
	}

	private void permute(List<List<Integer>> allPermutations, List<Integer> currentPermutation, int[] nums) {
		if (currentPermutation.size() == nums.length) {
			allPermutations.add(new ArrayList<>(currentPermutation));
			return;
		}
		for (int num : nums) {
			if (!currentPermutation.contains(num)) {
				currentPermutation.add(num);
				permute(allPermutations, currentPermutation, nums);
				currentPermutation.remove(currentPermutation.size() - 1);
			}
		}
	}
}
