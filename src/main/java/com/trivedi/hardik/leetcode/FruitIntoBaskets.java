package com.trivedi.hardik.leetcode;

/**
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * 
 * You start at any tree of your choice, then repeatedly perform the following
 * steps:
 * 
 * Add one piece of fruit from this tree to your baskets. If you cannot, stop.
 * Move to the next tree to the right of the current tree. If there is no tree
 * to the right, stop. Note that you do not have any choice after the initial
 * choice of starting tree: you must perform step 1, then step 2, then back to
 * step 1, then step 2, and so on until you stop.
 * 
 * You have two baskets, and each basket can carry any quantity of fruit, but
 * you want each basket to only carry one type of fruit each.
 * 
 * What is the total amount of fruit you can collect with this procedure?
 * 
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
