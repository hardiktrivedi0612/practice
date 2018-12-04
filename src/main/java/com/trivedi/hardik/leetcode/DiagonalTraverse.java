package com.trivedi.hardik.leetcode;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * @author hatrivedi
 * @date Dec 3, 2018
 * @since 2.5
 */
public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0)
			return new int[0];
		int m = matrix.length;
		int n = matrix[0].length;
		int result[] = new int[m * n];
		int row = 0;
		int col = 0;
		int direction = 0;
		int[][] directions = { { -1, 1 }, { 1, -1 } };
		for (int i = 0; i < m * n; i++) {
			result[i] = matrix[row][col];
			row += directions[direction][0];
			col += directions[direction][1];
			if (row >= m) {
				row = m - 1;
				col += 2;
				direction = 1 - direction;
			}
			if (col >= n) {
				col = n - 1;
				row += 2;
				direction = 1 - direction;
			}
			if (row < 0) {
				row = 0;
				direction = 1 - direction;
			}
			if (col < 0) {
				col = 0;
				direction = 1 - direction;
			}
		}
		return result;
	}
}
