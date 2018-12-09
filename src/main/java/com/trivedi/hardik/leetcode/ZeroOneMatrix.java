package com.trivedi.hardik.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * @author hatrivedi
 * @date Dec 8, 2018
 * @since 2.5
 */
public class ZeroOneMatrix {

	// BFS Solution
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix.length <= 0 || matrix[0].length <= 0) {
			return matrix;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;

		Queue<int[]> queue = new LinkedList<>();

		// Add cells with 0 into queue and mark others with distance MAX
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					queue.add(new int[] { i, j });
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int dirs[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

		while (!queue.isEmpty()) {
			int[] cell = queue.remove();
			for (int[] dir : dirs) {
				int r = cell[0] + dir[0];
				int c = cell[1] + dir[1];

				// If the surrounding cells are less far away from zero than
				// current cell then continue
				if (r < 0 || c < 0 || r >= rows || c >= cols || matrix[r][c] <= matrix[cell[0]][cell[1]]) {
					continue;
				}

				// Update the surrounding cell with + 1 value of current cell
				queue.add(new int[] { r, c });
				matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
			}
		}

		return matrix;

	}
}
