package com.trivedi.hardik.interviewcake;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

	private int V;
	private LinkedList<Integer> adj[];

	DFS(int v) {
		this.V = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void performIterativeDFS(int s) {
		boolean visited[] = new boolean[V];

		Deque<Integer> stack = new ArrayDeque<>();

		stack.push(s);
		visited[s] = true;

		while (stack.isEmpty() == false) {

			s = stack.pop();
			System.out.print(s + " ");

			Iterator<Integer> itr = adj[s].iterator();

			while (itr.hasNext()) {
				int v = itr.next();
				if (!visited[v]) {
					visited[v] = true;
					stack.push(v);
				}
			}
		}

	}

	public void performRecursiveDFS(int s) {
		boolean visited[] = new boolean[V];
		recursiveDFSUtil(s, visited);
	}

	private void recursiveDFSUtil(int s, boolean visited[]) {
		visited[s] = true;
		System.out.print(s + " ");

		Iterator<Integer> iter = adj[s].iterator();
		while (iter.hasNext()) {
			int n = iter.next();
			if (!visited[n]) {
				recursiveDFSUtil(n, visited);
			}
		}
	}

	public static void main(String[] args) {
		DFS g = new DFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
//		g.addEdge(1, 0);
//		g.addEdge(0, 2);
//		g.addEdge(2, 1);
//		g.addEdge(0, 3);
//		g.addEdge(1, 4);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.performIterativeDFS(2);
	}

}
