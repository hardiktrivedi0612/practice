package com.trivedi.hardik.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Let's play the minesweeper game (Wikipedia, online game)!
 * 
 * You are given a 2D char matrix representing the game board. 'M' represents an
 * unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a
 * revealed blank square that has no adjacent (above, below, left, right, and
 * all 4 diagonals) mines, digit ('1' to '8') represents how many mines are
 * adjacent to this revealed square, and finally 'X' represents a revealed mine.
 * 
 * Now given the next click position (row and column indices) among all the
 * unrevealed squares ('M' or 'E'), return the board after revealing this
 * position according to the following rules:
 * 
 * If a mine ('M') is revealed, then the game is over - change it to 'X'. If an
 * empty square ('E') with no adjacent mines is revealed, then change it to
 * revealed blank ('B') and all of its adjacent unrevealed squares should be
 * revealed recursively. If an empty square ('E') with at least one adjacent
 * mine is revealed, then change it to a digit ('1' to '8') representing the
 * number of adjacent mines. Return the board when no more squares will be
 * revealed.
 * 
 * @author hatrivedi
 * @date Dec 10, 2018
 * @since 2.5
 */
public class Minesweeper {

	// BFS Solution
	public char[][] updateBoard(char[][] board, int[] click) {
		if (board.length == 0 || board[0].length == 0) {
			return board;
		}
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(click);

		int dirs[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };
		while (!queue.isEmpty()) {
			int[] c = queue.remove();

			// Count number of mines next adjacent to current cell
			int count = 0;
			for (int[] dir : dirs) {
				int row = c[0] + dir[0];
				int col = c[1] + dir[1];
				if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
					continue;
				}
				if (board[row][col] == 'M' || board[row][col] == 'X') {
					count++;
				}
			}

			if (count > 0) {
				board[c[0]][c[1]] = (char) (count + '0');
			} else {
				board[c[0]][c[1]] = 'B';
				for (int[] dir : dirs) {
					int row = c[0] + dir[0];
					int col = c[1] + dir[1];
					if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'E') {
						continue;
					}
					queue.add(new int[] { row, col });
					board[row][col] = 'B';
				}
			}
		}
		return board;
	}

	// Faster DFS Solution
	public char[][] updateBoardDFS(char[][] board, int[] click) {
		if (board.length == 0 || board[0].length == 0) {
			return board;
		}
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}

		dfs(board, click[0], click[1]);
		return board;
	}

	int dirs[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };

	private void dfs(char[][] board, int row, int col) {
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'E') {
			return;
		}

		// Count number of mines next adjacent to current cell
		int count = 0;
		for (int[] dir : dirs) {
			int r = row + dir[0];
			int c = col + dir[1];
			if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
				continue;
			}
			if (board[r][c] == 'M' || board[r][c] == 'X') {
				count++;
			}
		}

		if (count > 0) {
			board[row][col] = (char) (count + '0');
		} else {
			board[row][col] = 'B';
			for (int[] dir : dirs) {
				int r = row + dir[0];
				int c = col + dir[1];
				dfs(board, r, c);
			}
		}
	}
}
