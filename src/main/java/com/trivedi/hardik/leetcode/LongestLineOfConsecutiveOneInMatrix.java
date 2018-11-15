package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 15, 2018
 * @since 2.5
 */
public class LongestLineOfConsecutiveOneInMatrix {

	// Correct DP solution
	public int longestLine(int[][] M) {
		int n = M.length, max = 0;
		if (n == 0)
			return max;
		int m = M[0].length;
		int[][][] dp = new int[n][m][4];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (M[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++)
					dp[i][j][k] = 1;
				if (j > 0)
					dp[i][j][0] += dp[i][j - 1][0]; // horizontal line
				if (j > 0 && i > 0)
					dp[i][j][1] += dp[i - 1][j - 1][1]; // anti-diagonal line
				if (i > 0)
					dp[i][j][2] += dp[i - 1][j][2]; // vertical line
				if (j < m - 1 && i > 0)
					dp[i][j][3] += dp[i - 1][j + 1][3]; // diagonal line
				max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
				max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
			}
		return max;
	}

	// My Solution using DFS
	public int longestLineDFS(int[][] M) {
		if (M.length == 0 || M[0].length == 0) {
			return 0;
		}

		int maxLength = 0;
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][j] == 1) {
					maxLength = Math.max(maxLength, calculateLineLengths(M, i, j));
				}
			}
		}
		return maxLength;
	}

	private int calculateLineLengths(int[][] M, int i, int j) {
		int maxInDirection = 0;
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				if (x != 0 || y != 0) {
					maxInDirection = Math.max(maxInDirection, calculateLineLengthsHelper(M, i + x, j + y, x, y));
				}
			}
		}

		return maxInDirection + 1;
	}

	private int calculateLineLengthsHelper(int[][] M, int i, int j, int x, int y) {
		if (i < 0 || j < 0 || i >= M.length || j >= M[0].length || M[i][j] == 0) {
			return 0;
		}
		return calculateLineLengthsHelper(M, i + x, j + y, x, y) + 1;
	}

	public static void main(String[] args) {
		LongestLineOfConsecutiveOneInMatrix app = new LongestLineOfConsecutiveOneInMatrix();
		int array[][] = new int[3][4];
		array[0][0] = 1;
		array[0][1] = 1;
		array[0][2] = 1;
		array[0][3] = 1;
		array[1][0] = 0;
		array[1][1] = 1;
		array[1][2] = 1;
		array[1][3] = 0;
		array[2][0] = 0;
		array[2][1] = 0;
		array[2][2] = 0;
		array[2][3] = 1;
		System.out.println("Start");
		System.out.println(app.longestLine(array));
		System.out.println("End");
	}
}
