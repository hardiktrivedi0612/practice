package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class RobotReturnToOrigin {
	public boolean judgeCircle(String moves) {
		int vertical = 0;
		int horizontal = 0;
		for (int i = 0; i < moves.length(); i++) {
			if (moves.charAt(i) == 'U') {
				vertical++;
			} else if (moves.charAt(i) == 'D') {
				vertical--;
			} else if (moves.charAt(i) == 'L') {
				horizontal--;
			} else if (moves.charAt(i) == 'R') {
				horizontal++;
			}
		}
		return (horizontal == 0 && vertical == 0);
	}
}
