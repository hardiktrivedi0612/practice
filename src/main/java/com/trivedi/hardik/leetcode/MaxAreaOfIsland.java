package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 6, 2018
 * @since 2.5
 */
public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		Integer area = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					area = Math.max(area, calculateAreaForIsland(grid, i, j));
				}
			}
		}
		return area;
	}

	private int calculateAreaForIsland(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;
		return calculateAreaForIsland(grid, i - 1, j) + calculateAreaForIsland(grid, i + 1, j)
				+ calculateAreaForIsland(grid, i, j - 1) + calculateAreaForIsland(grid, i, j + 1) + 1;
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] { new int[] { 1, 1, 0, 0, 0 }, new int[] { 1, 1, 0, 0, 0 },
				new int[] { 0, 0, 0, 1, 1 }, new int[] { 0, 0, 0, 1, 1 } };
		MaxAreaOfIsland maxArea = new MaxAreaOfIsland();
		System.out.println(maxArea.maxAreaOfIsland(grid));
	}

}
