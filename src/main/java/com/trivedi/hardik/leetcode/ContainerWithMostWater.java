/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class ContainerWithMostWater {

	// Two pointers solution
	public int maxArea(int[] height) {
		int maxArea = -1;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

	// O(n2) solution
	public int maxAreaON2(int[] height) {
		int maxArea = -1;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int area = (j - i) * Math.min(height[i], height[j]);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}

}
