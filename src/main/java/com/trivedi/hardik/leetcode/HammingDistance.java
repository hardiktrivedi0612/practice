package com.trivedi.hardik.leetcode;

/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}
}
