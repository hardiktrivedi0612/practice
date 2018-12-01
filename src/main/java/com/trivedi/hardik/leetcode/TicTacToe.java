package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 30, 2018
 * @since 2.5
 */
public class TicTacToe {

	private int rows[], cols[];
	int diagonal, antiDiagonal;

	// Naive soltion
	private int[][] naive;

	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];
		diagonal = 0;
		antiDiagonal = 0;

		// Naive solution initialization
		naive = new int[n][n];
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row
	 *            The row of the board.
	 * @param col
	 *            The column of the board.
	 * @param player
	 *            The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		int count = player == 1 ? 1 : -1;

		rows[row] += count;
		cols[col] += count;
		if (row == col) {
			diagonal += count;
		}
		if (col + row + 1 == cols.length) {
			antiDiagonal += count;
		}

		int size = rows.length;
		if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size
				|| Math.abs(antiDiagonal) == size) {
			return player;
		}
		return 0;
	}

	public int moveNaive(int row, int col, int player) {

		naive[row][col] = player;

		// Check row win
		boolean win = true;
		for (int i = 0; i < naive.length; i++) {
			if (naive[row][i] != player) {
				win = false;
				break;
			}
		}
		if (win)
			return player;

		// Check column win
		win = true;
		for (int i = 0; i < naive.length; i++) {
			if (naive[i][col] != player) {
				win = false;
				break;
			}
		}
		if (win)
			return player;

		// Check diagonal win
		win = true;
		for (int i = 0; i < naive.length; i++) {
			if (naive[i][i] != player) {
				win = false;
				break;
			}
		}
		if (win)
			return player;

		// Check anti-diagonal win
		win = true;
		for (int i = 0; i < naive.length; i++) {
			if (naive[i][naive.length - i - 1] != player) {
				win = false;
				break;
			}
		}
		if (win)
			return player;

		return 0;

	}
}
