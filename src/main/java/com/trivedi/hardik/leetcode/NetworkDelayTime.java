package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 * 
 * 
 * @author hatrivedi
 * @date Dec 9, 2018
 * @since 2.5
 */
public class NetworkDelayTime {

	// Normal Dijkstra's algorithm implementation
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] edge : times) {
			if (!graph.containsKey(edge[0]))
				graph.put(edge[0], new ArrayList<int[]>());
			graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
		}
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>((info1, info2) -> info1[0] - info2[0]);
		heap.offer(new int[] { 0, K });

		Map<Integer, Integer> dist = new HashMap<>();

		while (!heap.isEmpty()) {
			int[] info = heap.poll();
			int d = info[0], node = info[1];
			if (dist.containsKey(node))
				continue;
			dist.put(node, d);
			if (graph.containsKey(node))
				for (int[] edge : graph.get(node)) {
					int nei = edge[0], d2 = edge[1];
					if (!dist.containsKey(nei))
						heap.offer(new int[] { d + d2, nei });
				}
		}

		if (dist.size() != N)
			return -1;
		int ans = 0;
		for (int cand : dist.values())
			ans = Math.max(ans, cand);
		return ans;
	}

	// Better implementation of Dijkstra's algorithm
	public int networkDelayTime1(int[][] times, int N, int K) {

		// Dijkstra's shortest path algorithm

		// Create adjacency matrix
		int[][] adj = new int[N + 1][N + 1];
		for (int[] arr : adj) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		for (int[] edge : times) {
			adj[edge[0]][edge[1]] = edge[2];
		}

		int[] result = new int[N + 1];
		Arrays.fill(result, Integer.MAX_VALUE);

		// Min heap so that edges with less distance are closest to head
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
			@Override
			public int compare(Integer obj1, Integer obj2) {
				return result[obj1] - result[obj2];
			}
		});

		result[K] = 0;
		heap.offer(K);

		while (!heap.isEmpty()) {
			int node = heap.poll();
			for (int i = 1; i <= N; i++) {
				if (adj[node][i] != Integer.MAX_VALUE && result[i] > result[node] + adj[node][i]) {
					result[i] = result[node] + adj[node][i];
					heap.offer(i);
				}
			}
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (result[i] == Integer.MAX_VALUE) {
				return -1;
			}
			ans = Math.max(ans, result[i]);
		}
		return ans;
	}
}
