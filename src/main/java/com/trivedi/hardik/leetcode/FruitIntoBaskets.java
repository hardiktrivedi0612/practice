package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 8, 2018
 * @since 2.5
 */
public class FruitIntoBaskets {
	public int totalFruit(int[] tree) {
		int first = tree[0];
		int second = -1;
		int fcnt = 1;
		int scnt = 0;
		int fcont = 1;
		int scont = 0;
		int last = tree[0];
		int max = 1;
		for (int i = 1; i < tree.length; i++) {
			if (tree[i] == first) {
				fcnt++;
				if (last == tree[i]) {
					fcont++;
				} else {
					fcont = 1;
				}
			} else if (tree[i] == second) {
				scnt++;
				if (last == tree[i]) {
					scont++;
				} else {
					scont = 1;
				}
			} else if (second == -1) {
				second = tree[i];
				scnt = 1;
				scont = 1;
			} else {
				if (last == first) {
					second = tree[i];
					scnt = 1;
					scont = 1;
					fcnt = fcont;
				} else {
					first = tree[i];
					fcnt = 1;
					fcont = 1;
					scnt = scont;
				}
			}
			last = tree[i];
			if (fcnt + scnt > max) {
				max = fcnt + scnt;
			}
		}
		return max;
	}

	// Smaller solution
	public int totalFruit2(int[] tree) {
		int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
		for (int c : tree) {
			cur = c == a || c == b ? cur + 1 : count_b + 1;
			count_b = c == b ? count_b + 1 : 1;
			if (b != c) {
				a = b;
				b = c;
			}
			res = Math.max(res, cur);
		}
		return res;
	}

	public static void main(String[] args) {
		FruitIntoBaskets app = new FruitIntoBaskets();
		System.out.println(app.totalFruit(new int[] { 1, 0, 0, 0, 1, 0, 4, 0, 4 }));
	}
}
