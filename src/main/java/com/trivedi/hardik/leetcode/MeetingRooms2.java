package com.trivedi.hardik.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * @author hatrivedi
 * @date Nov 7, 2018
 * @since 2.5
 */
public class MeetingRooms2 {

	// Priority queue solution
	public int minMeetingRooms(Interval[] intervals) {

		if (intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});
		heap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval interval = heap.poll();
			if (intervals[i].start >= interval.end) {
				interval.end = intervals[i].end;
			} else {
				heap.offer(intervals[i]);
			}
			heap.offer(interval);
		}

		return heap.size();
	}

	// Most optimized solution
	public int minMeetingRooms2(Interval[] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			Interval in = intervals[i];
			start[i] = in.start;
			end[i] = in.end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		// [1,4,5,7,9,12]
		// [3,5,8,10,11,15]
		// [[0,30],[5,10],[15,20]]
		// 0,5,15,20
		// 10,20,30,25
		int j = 0;
		int count = 1;
		for (int i = 1; i < start.length; i++) {
			if (j < i && start[i] >= end[j]) {
				j++;
			} else if (start[i] < end[j]) {
				count++;
			}
		}
		return count;
	}
}
