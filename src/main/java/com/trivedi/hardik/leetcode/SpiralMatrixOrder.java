package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hatrivedi
 * @date Nov 30, 2018
 * @since 2.5
 */
public class SpiralMatrixOrder {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return Collections.emptyList();
		}
		List<Integer> response = new ArrayList<>();
		int colRightBound = matrix[0].length - 1;
		int colLeftBound = 0;
		int rowBottomBound = matrix.length - 1;
		int rowTopBound = 0;
		while (rowTopBound <= rowBottomBound && colLeftBound <= colRightBound) {
			for (int i = colLeftBound; i <= colRightBound; i++) {
				response.add(matrix[rowTopBound][i]);
			}
			rowTopBound++;
			for (int i = rowTopBound; i <= rowBottomBound; i++) {
				response.add(matrix[i][colRightBound]);
			}
			colRightBound--;
			if (rowTopBound <= rowBottomBound) {
				for (int i = colRightBound; i >= colLeftBound; i--) {
					response.add(matrix[rowBottomBound][i]);
				}
			}
			rowBottomBound--;
			if (colLeftBound <= colRightBound) {
				for (int i = rowBottomBound; i >= rowTopBound; i--) {
					response.add(matrix[i][colLeftBound]);
				}
			}
			colLeftBound++;
		}
		return response;
	}
}
