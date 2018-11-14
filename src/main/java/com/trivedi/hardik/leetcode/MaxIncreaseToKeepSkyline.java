package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 14, 2018
 * @since 2.5
 */
public class MaxIncreaseToKeepSkyline {

	// My solution
	public int maxIncreaseKeepingSkyline1(int[][] grid) {
		int newGrid[][] = new int[grid.length][grid[0].length];

		// Row wise scan
		for (int i = 0; i < grid.length; i++) {
			int currentRowMax = -1;
			for (int j = 0; j < grid[i].length; j++) {
				currentRowMax = Math.max(currentRowMax, grid[i][j]);
			}
			for (int j = 0; j < grid[i].length; j++) {
				newGrid[i][j] = currentRowMax;
			}
		}

		// Column wise scan
		for (int j = 0; j < grid[0].length; j++) {
			int currentColumnMax = -1;
			for (int i = 0; i < grid.length; i++) {
				currentColumnMax = Math.max(currentColumnMax, grid[i][j]);
			}
			for (int i = 0; i < grid.length; i++) {
				newGrid[i][j] = Math.min(newGrid[i][j], currentColumnMax);
			}
		}

		// Calculate the total
		int maxIncrease = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				maxIncrease += (newGrid[i][j] - grid[i][j]);
			}
		}
		return maxIncrease;
	}

	// Proper solution
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int rowMaxes[] = new int[grid.length];
		int columnMaxes[] = new int[grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				rowMaxes[i] = Math.max(rowMaxes[i], grid[i][j]);
				columnMaxes[j] = Math.max(columnMaxes[j], grid[i][j]);
			}
		}
		int maxIncrease = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				maxIncrease += (Math.min(rowMaxes[i], columnMaxes[j]) - grid[i][j]);
			}
		}
		return maxIncrease;
	}
}
