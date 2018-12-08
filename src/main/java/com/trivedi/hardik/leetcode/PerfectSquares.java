package com.trivedi.hardik.leetcode;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * 
 * @author hatrivedi
 * @date Dec 8, 2018
 * @since 2.5
 */
public class PerfectSquares {
	public int numSquares(int n) {
		if (n < 1) {
			return 0;
		}
		int[] res = new int[n + 1];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;
		for (int i = 1; i <= n; i++) {
			// we use j * j to re-calc the res array
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, res[i - j * j] + 1);
			}
			res[i] = min;
		}
		return res[n];
	}
}
