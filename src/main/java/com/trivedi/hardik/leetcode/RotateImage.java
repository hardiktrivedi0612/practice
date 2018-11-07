package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 7, 2018
 * @since 2.5
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			rotate(matrix[i]);
		}
	}

	public void rotate(int[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}
}
