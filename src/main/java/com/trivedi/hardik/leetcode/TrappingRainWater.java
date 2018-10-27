package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class TrappingRainWater {

	// O(n2) solution
	public int trap(int[] height) {
		int trappedWater = 0;

		for (int i = 1; i < height.length - 1; i++) {
			int maxLeft = 0, maxRight = 0;
			for (int j = i; j >= 0; j--) {
				maxLeft = Math.max(maxLeft, height[j]);
			}
			for (int j = i; j < height.length; j++) {
				maxRight = Math.max(maxRight, height[j]);
			}
			trappedWater += Math.min(maxRight, maxLeft) - height[i];
		}

		return trappedWater;
	}

	// O(n) solution
	public int trap2(int[] height) {
		int trappedWater = 0;

		if (height == null || height.length == 0) {
			return 0;
		}

		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];

		leftMax[0] = height[0];
		rightMax[rightMax.length - 1] = height[rightMax.length - 1];

		for (int i = 1; i < leftMax.length; i++) {
			leftMax[i] = Math.max(height[i], leftMax[i - 1]);
		}

		for (int i = rightMax.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(height[i], rightMax[i + 1]);
		}

		for (int i = 1; i < height.length - 1; i++) {
			trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
		}

		return trappedWater;
	}
}
