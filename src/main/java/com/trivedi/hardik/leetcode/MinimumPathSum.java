/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

import java.util.HashMap;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class MinimumPathSum {

	// Solution 1
	private HashMap<String, Integer> map = new HashMap<>();

	public int minPathSum(int[][] grid) {
		return minPathSum(grid, 0, 0);
	}

	public int minPathSum(int[][] grid, int i, int j) {
		if (this.map.containsKey(i + "-" + j)) {
			return map.get(i + "-" + j);
		}
		if (i > grid.length - 1 || j > grid[0].length - 1) {
			this.map.put(i + "-" + j, Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		} else if (i == grid.length - 1 && j == grid[0].length - 1) {
			this.map.put(i + "-" + j, grid[i][j]);
			return grid[i][j];
		}
		int rightMinSum = minPathSum(grid, i, j + 1);
		int bottomMinSum = minPathSum(grid, i + 1, j);

		this.map.put(i + "-" + j, grid[i][j] + Math.min(rightMinSum, bottomMinSum));
		return grid[i][j] + Math.min(rightMinSum, bottomMinSum);
	}
	
	
	
	
	

	// Solution 2
	public int minPathSum2(int[][] grid) {
		int[][] cost = new int[grid.length][grid[0].length];
		if (grid.length == 1 && grid[0].length == 1) {
			return grid[0][0];
		}
		return minPathSum(grid, 0, 0, cost);
	}

	public int minPathSum(int[][] grid, int i, int j, int cost[][]) {
		if (cost[i][j] != 0) {
			return cost[i][j];
		}

		if (i + 1 == grid.length && j + 1 == grid[0].length) {
			return grid[i][j];
		} else if (i + 1 == grid.length) {
			return grid[i][j] + minPathSum(grid, i, j + 1, cost);
		} else if (j + 1 == grid[0].length) {
			return grid[i][j] + minPathSum(grid, i + 1, j, cost);
		}

		int minPathSum = grid[i][j] + Math.min(minPathSum(grid, i, j + 1, cost), minPathSum(grid, i + 1, j, cost));
		cost[i][j] = minPathSum;
		return minPathSum;
	}

}
