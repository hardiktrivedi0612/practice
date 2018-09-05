package com.trivedi.hardik.general;

/**
 * Let us consider the following problem to understand Segment Trees.
 * 
 * We have an array arr[0 . . . n-1]. We should be able to 1 Find the sum of
 * elements from index l to r where 0 <= l <= r <= n-1
 * 
 * 2 Change value of a specified element of the array to a new value x. We need
 * to do arr[i] = x where 0 <= i <= n-1.
 * 
 * 
 * @author hardik
 *
 */
public class SegmentTree {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		SegmentTreeSet1 tree = new SegmentTree().new SegmentTreeSet1(arr, n);

		// Build segment tree from given array

		// Print sum of values in array from index 1 to 3
		System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));

		// Update: set arr[1] = 10 and update corresponding segment
		// tree nodes
		tree.updateValue(arr, n, 1, 10);

		// Find sum after the value is updated
		System.out.println("Updated sum of values in given range = " + tree.getSum(n, 1, 3));

		SegmentTreeSet2 tree2 = new SegmentTree().new SegmentTreeSet2();

		// Build segment tree from given array
		tree2.constructSegmentTree(arr, n);

		int qs = 1; // Starting index of query range
		int qe = 5; // Ending index of query range

		// Print minimum value in arr[qs..qe]
		System.out.println("Minimum of values in range [" + qs + ", " + qe + "] is = " + tree2.rmq(n, qs, qe));
	}

	/**
	 * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
	 * 
	 * @author hardik
	 *
	 */
	class SegmentTreeSet1 {
		int segmentTree[];

		SegmentTreeSet1(int arr[], int n) {
			int heightOfSegmentTree = (int) Math.ceil(Math.log(n) / Math.log(2));
			int sizeOfSegmentTree = 2 * (int) Math.pow(2, heightOfSegmentTree) - 1;
			segmentTree = new int[sizeOfSegmentTree];
			constructSegmentTree(arr, 0, n - 1, 0);
		}

		int constructSegmentTree(int[] arr, int startIndex, int endIndex, int currentIndex) {
			if (startIndex == endIndex) {
				segmentTree[currentIndex] = arr[startIndex];
				return arr[startIndex];
			}
			int mid = getMid(startIndex, endIndex);
			segmentTree[currentIndex] = constructSegmentTree(arr, startIndex, mid, currentIndex * 2 + 1)
					+ constructSegmentTree(arr, mid + 1, endIndex, currentIndex * 2 + 2);
			return segmentTree[currentIndex];
		}

		int getMid(int startIndex, int endIndex) {
			return startIndex + (endIndex - startIndex) / 2;
		}

		void updateValue(int arr[], int n, int index, int newValue) {
			if (index < 0 || index > n - 1) {
				throw new IllegalArgumentException("Illegal value of i in input");
			}
			int diff = newValue - arr[index];
			arr[index] = newValue;
			updateValueUtil(0, n - 1, index, diff, 0);
		}

		void updateValueUtil(int startIndex, int endIndex, int index, int diff, int currentIndex) {
			if (index < startIndex || index > endIndex) {
				return;
			}
			segmentTree[currentIndex] += diff;
			if (startIndex != endIndex) {
				int mid = getMid(startIndex, endIndex);
				updateValueUtil(startIndex, mid, index, diff, 2 * currentIndex + 1);
				updateValueUtil(mid + 1, endIndex, index, diff, 2 * currentIndex + 2);
			}
		}

		int getSum(int n, int queryStart, int queryEnd) {
			if (queryStart < 0 || queryEnd > n - 1 || queryStart > queryEnd) {
				throw new IllegalArgumentException("Illegal values in input");
			}
			return getSumUtil(0, n - 1, queryStart, queryEnd, 0);
		}

		int getSumUtil(int startIndex, int endIndex, int queryStart, int queryEnd, int currentIndex) {
			if (queryStart <= startIndex && queryEnd >= endIndex) {
				return segmentTree[currentIndex];
			}
			if (endIndex < queryStart || startIndex > queryEnd) {
				return 0;
			}
			int mid = getMid(startIndex, endIndex);
			return getSumUtil(startIndex, mid, queryStart, queryEnd, 2 * currentIndex + 1)
					+ getSumUtil(mid + 1, endIndex, queryStart, queryEnd, 2 * currentIndex + 2);
		}

	}

	/**
	 * 
	 * https://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
	 * 
	 * Set 2 - Range minimum query
	 * 
	 * @author hardik
	 *
	 */
	class SegmentTreeSet2 {
		int segmentTree[];

		public SegmentTreeSet2() {
		}

		void constructSegmentTree(int arr[], int n) {
			int heightOfSegmentTree = (int) Math.ceil(Math.log(n) / Math.log(2));
			int sizeOfSegmentTree = 2 * (int) Math.pow(2, heightOfSegmentTree) - 1;
			segmentTree = new int[sizeOfSegmentTree];
			constructSegmentTreeUtil(arr, 0, n - 1, 0);
		}

		int constructSegmentTreeUtil(int[] arr, int startIndex, int endIndex, int currentIndex) {
			if (startIndex == endIndex) {
				segmentTree[currentIndex] = arr[startIndex];
				return arr[startIndex];
			}
			int mid = getMid(startIndex, endIndex);
			segmentTree[currentIndex] = minVal(constructSegmentTreeUtil(arr, startIndex, mid, currentIndex * 2 + 1),
					constructSegmentTreeUtil(arr, mid + 1, endIndex, currentIndex * 2 + 2));
			return segmentTree[currentIndex];
		}

		int minVal(int x, int y) {
			return Math.min(x, y);
		}

		int getMid(int startIndex, int endIndex) {
			return startIndex + (endIndex - startIndex) / 2;
		}

		int rmq(int n, int queryStart, int queryEnd) {
			if (queryStart < 0 || queryEnd > n - 1 || queryStart > queryEnd) {
				throw new IllegalArgumentException("Illegal values in input");
			}
			return rmqUtil(0, n - 1, queryStart, queryEnd, 0);
		}

		int rmqUtil(int startIndex, int endIndex, int queryStart, int queryEnd, int currentIndex) {
			if (queryStart <= startIndex && queryEnd >= endIndex) {
				return segmentTree[currentIndex];
			}
			if (endIndex < queryStart || startIndex > queryEnd) {
				return Integer.MAX_VALUE;
			}
			int mid = getMid(startIndex, endIndex);
			return minVal(rmqUtil(startIndex, mid, queryStart, queryEnd, 2 * currentIndex + 1),
					rmqUtil(mid + 1, endIndex, queryStart, queryEnd, 2 * currentIndex + 2));
		}
	}

}
