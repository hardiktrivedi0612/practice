package com.trivedi.hardik.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * @author hatrivedi
 * @date Dec 7, 2018
 * @since 2.5
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// Kahn's algorithm for topological sorting

		// Instead of using 2D array, use array list
		int[][] matrix = new int[numCourses][numCourses];
		int[] incomingEdges = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int prerequisite = prerequisites[i][1];
			if (matrix[prerequisite][course] == 0) {
				incomingEdges[course]++;
			}
			matrix[prerequisite][course] = 1;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (incomingEdges[i] == 0) {
				queue.add(i);
			}
		}

		int count = 0;
		while (!queue.isEmpty()) {
			int node = queue.remove();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[node][i] != 0) {
					if (--incomingEdges[i] <= 0) {
						queue.add(i);
					}
				}
			}
		}
		return count == numCourses;

	}
}
