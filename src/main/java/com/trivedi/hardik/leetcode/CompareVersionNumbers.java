/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] version1Splits = version1.split("\\.");
		String[] version2Splits = version2.split("\\.");

		int i = 0;
		int j = 0;
		while (i < version1Splits.length || j < version2Splits.length) {
			if (i == version1Splits.length && j < version2Splits.length) {
				while (j != version2Splits.length) {
					int v2 = Integer.parseInt(version2Splits[j]);
					if (v2 != 0) {
						return -1;
					}
					j++;
				}
				return 0;
			} else if (i < version1Splits.length && j == version2Splits.length) {
				while (i != version1Splits.length) {
					int v1 = Integer.parseInt(version1Splits[i]);
					if (v1 != 0) {
						return 1;
					}
					i++;
				}
				return 0;
			}

			int v1 = Integer.parseInt(version1Splits[i]);
			int v2 = Integer.parseInt(version2Splits[j]);
			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
			i++;
			j++;
		}
		return 0;
	}
}
