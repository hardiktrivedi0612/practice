package com.trivedi.hardik.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
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
