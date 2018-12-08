package com.trivedi.hardik.leetcode;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 * 
 * @author hatrivedi
 * @date Dec 8, 2018
 * @since 2.5
 */
public class SurroundingRegions {
	public void solve(char[][] board) {
		if (board.length <= 1 || board[0].length <= 1) {
			return;
		}

		// Marking O to * for first and last columns
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				helper(board, i, 0);
			}
			if (board[i][board[0].length - 1] == 'O') {
				helper(board, i, board[0].length - 1);
			}
		}

		// Marking O to * for first and last rows
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				helper(board, 0, i);
			}
			if (board[board.length - 1][i] == 'O') {
				helper(board, board.length - 1, i);
			}
		}

		// Marking rest of O to X and * back to O
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}

	}

	private void helper(char[][] board, int r, int c) {
		if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O')
			return;
		board[r][c] = '*';
		helper(board, r + 1, c);
		helper(board, r - 1, c);
		helper(board, r, c + 1);
		helper(board, r, c - 1);
	}
}
