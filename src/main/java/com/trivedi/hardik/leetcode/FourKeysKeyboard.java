package com.trivedi.hardik.leetcode;

/**
 * Imagine you have a special keyboard with the following keys:
 * 
 * Key 1: (A): Print one 'A' on screen.
 * 
 * Key 2: (Ctrl-A): Select the whole screen.
 * 
 * Key 3: (Ctrl-C): Copy selection to buffer.
 * 
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already
 * been printed.
 * 
 * Now, you can only press the keyboard for N times (with the above four keys),
 * find out the maximum numbers of 'A' you can print on screen.
 * 
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class FourKeysKeyboard {
	public int maxA(int N) {
		int[] dp = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j <= i - 3; j++)
				dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
		}
		return dp[N];
	}

	public int maxARecursive(int n) {
		int max = n;
		for (int i = 1; i <= n - 3; i++)
			max = Math.max(max, maxARecursive(i) * (n - i - 1));
		return max;
	}
}
