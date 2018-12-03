package com.trivedi.hardik.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else if (n < 0) {
			return 0;
		}
		int noOfWays[] = new int[n + 1];
		noOfWays[0] = 1;
		noOfWays[1] = 1;
		for (int i = 2; i <= n; i++) {
			noOfWays[i] = noOfWays[i - 1] + noOfWays[i - 2];
		}
		return noOfWays[n];
	}
}
