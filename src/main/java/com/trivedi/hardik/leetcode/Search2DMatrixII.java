/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int col = matrix[0].length - 1;
		int row = 0;
		while (col >= 0 && row <= matrix.length - 1) {

			if (target == matrix[row][col]) {
				return true;
			} else if (target > matrix[row][col]) {
				row++;
			} else if (target < matrix[row][col]) {
				col--;
			}
		}
		return false;
	}
}
