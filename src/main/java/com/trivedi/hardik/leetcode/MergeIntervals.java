package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty()) {
			return Collections.emptyList();
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}

		});
		List<Interval> mergedIntervals = new ArrayList<>();
		mergedIntervals.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start <= mergedIntervals.get(mergedIntervals.size() - 1).end) {
				mergedIntervals.get(mergedIntervals.size() - 1).end = Math.max(intervals.get(i).end,
						mergedIntervals.get(mergedIntervals.size() - 1).end);
			} else {
				mergedIntervals.add(intervals.get(i));
			}
		}
		return mergedIntervals;
	}
}
