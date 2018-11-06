package com.trivedi.hardik.leetcode.dfs;

/**
 * @author hatrivedi
 * @date Nov 5, 2018
 * @since 2.5
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {

		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					performDFSAndClearIsland(grid, i, j);
				}
			}
		}

		return count;

	}

	private void performDFSAndClearIsland(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		performDFSAndClearIsland(grid, i, j - 1);
		performDFSAndClearIsland(grid, i, j + 1);
		performDFSAndClearIsland(grid, i + 1, j);
		performDFSAndClearIsland(grid, i - 1, j);
	}
}
