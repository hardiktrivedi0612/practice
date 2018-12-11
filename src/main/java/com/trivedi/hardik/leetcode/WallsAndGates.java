package com.trivedi.hardik.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room.
 * We use the value 231 - 1 = 2147483647 to represent INF as you may assume that
 * the distance to a gate is less than 2147483647. Fill each empty room with the
 * distance to its nearest gate. If it is impossible to reach a gate, it should
 * be filled with INF.
 * 
 * 
 * @author hatrivedi
 * @date Dec 10, 2018
 * @since 2.5
 */
public class WallsAndGates {
	// BFS Solution
	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0) {
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					queue.add(new int[] { i, j });
				}
			}
		}
		int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		while (!queue.isEmpty()) {
			int[] cell = queue.remove();
			for (int[] dir : dirs) {
				int row = cell[0] + dir[0];
				int col = cell[1] + dir[1];
				if (row < 0 || col < 0 || row >= rooms.length || col >= rooms[0].length
						|| rooms[row][col] != Integer.MAX_VALUE) {
					continue;
				}
				rooms[row][col] = rooms[cell[0]][cell[1]] + 1;
				queue.add(new int[] { row, col });
			}
		}
	}

	// Faster DFS Solution
	int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public void wallsAndGatesDFS(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0) {
			return;
		}

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					for (int[] dir : dirs) {
						dfs(rooms, i + dir[0], j + dir[1], rooms[i][j]);
					}
				}
			}
		}
	}

	private void dfs(int[][] rooms, int row, int col, int value) {
		if (row < 0 || col < 0 || row >= rooms.length || col >= rooms[0].length) {
			return;
		}
		if (rooms[row][col] > 0 && rooms[row][col] > value + 1) {
			rooms[row][col] = value + 1;
			for (int[] dir : dirs) {
				dfs(rooms, row + dir[0], col + dir[1], rooms[row][col]);
			}
		}

	}
}
