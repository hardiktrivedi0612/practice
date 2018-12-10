package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell
 * to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 * 
 * Note: The order of returned grid coordinates does not matter. Both m and n
 * are less than 150.
 * 
 * @author hatrivedi
 * @date Dec 10, 2018
 * @since 2.5
 */
public class PacificAtlanticWaterFlow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		boolean[][] pacificPaths = new boolean[matrix.length][matrix[0].length];
		boolean[][] atlanticPaths = new boolean[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			dfs(matrix, pacificPaths, i, 0, Integer.MIN_VALUE);
			dfs(matrix, atlanticPaths, i, matrix[0].length - 1, Integer.MIN_VALUE);
		}

		for (int j = 0; j < matrix[0].length; j++) {
			dfs(matrix, pacificPaths, 0, j, Integer.MIN_VALUE);
			dfs(matrix, atlanticPaths, matrix.length - 1, j, Integer.MIN_VALUE);
		}

		List<int[]> response = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (pacificPaths[i][j] && atlanticPaths[i][j]) {
					response.add(new int[] { i, j });
				}
			}
		}
		return response;
	}

	int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public void dfs(int[][] matrix, boolean[][] path, int row, int col, int parentVal) {
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] > parentVal
				|| path[row][col]) {
			return;
		}
		path[row][col] = true;
		for (int[] dir : dirs) {
			dfs(matrix, path, row + dir[0], col + dir[0], matrix[row][col]);
		}
	}

}
