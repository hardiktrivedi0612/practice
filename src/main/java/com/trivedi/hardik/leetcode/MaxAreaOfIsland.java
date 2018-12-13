package com.trivedi.hardik.leetcode;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
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
