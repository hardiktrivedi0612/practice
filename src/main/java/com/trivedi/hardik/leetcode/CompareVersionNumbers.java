package com.trivedi.hardik.leetcode;

/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1; if version1 < version2 return -1;otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not "two and a
 * half" or "half way to version three", it is the fifth second-level revision
 * of the second first-level revision.
 * 
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
