package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * @author hatrivedi
 * @date Nov 7, 2018
 * @since 2.5
 */
public class MajorityElement2 {

	// Boyer-Moore Majority Vote algorithm solution
	// (http://goo.gl/64Nams)
	// And since the requirement is finding the majority for more than ceiling
	// of [n/3], the answer would be less than or equal to two numbers.
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> response = new ArrayList<>();
		int candidate1 = 0;
		int candidate2 = 1;
		int count1 = 0;
		int count2 = 0;

		for (int i : nums) {
			if (i == candidate1) {
				count1++;
			} else if (i == candidate2) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = i;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = i;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		int candidate1Count = 0;
		int candidate2Count = 0;

		for (int i : nums) {
			if (i == candidate1) {
				candidate1Count++;
			}
			if (i == candidate2) {
				candidate2Count++;
			}
		}

		if (candidate1Count > (nums.length / 3)) {
			response.add(candidate1);
		}

		if (candidate2Count > (nums.length / 3)) {
			response.add(candidate2);
		}

		return response;

	}
}
