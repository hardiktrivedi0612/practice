package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> response = new ArrayList<>();
		Set<String> tripletSet = new HashSet<String>();
		for (int i = 0; i < nums.length - 1; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i + 1; j < nums.length; j++) {
				if (set.contains(-(nums[i] + nums[j]))) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(-(nums[i] + nums[j]));
					Collections.sort(list);
					if (!tripletSet.contains(list.get(0) + "-" + list.get(1) + "-" + list.get(2))) {
						response.add(list);
						tripletSet.add(list.get(0) + "-" + list.get(1) + "-" + list.get(2));
					}
				} else {
					set.add(nums[j]);
				}
			}
		}
		return response;
	}

	// Two pointer approach
	public List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> response = new ArrayList<>();
		for (int i = 0; i < nums.length - 1; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == 0) {
					response.add(Arrays.asList(nums[i], nums[l], nums[r]));
					int leftNum = nums[l], rightNum = nums[r];
					while (l < r && leftNum == nums[l]) {
						l++;
					}
					while (l < r && rightNum == nums[r]) {
						r--;
					}
				} else if (sum < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
		return response;
	}
}
