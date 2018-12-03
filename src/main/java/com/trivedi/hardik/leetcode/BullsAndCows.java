package com.trivedi.hardik.leetcode;

/**
 * You are playing the following Bulls and Cows game with your friend: You write
 * down a number and ask your friend to guess what the number is. Each time your
 * friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position
 * (called "bulls") and how many digits match the secret number but locate in
 * the wrong position (called "cows"). Your friend will use successive guesses
 * and hints to eventually derive the secret number.
 * 
 * Write a function to return a hint according to the secret number and friend's
 * guess, use A to indicate the bulls and B to indicate the cows.
 * 
 * Please note that both secret number and friend's guess may contain duplicate
 * digits.
 * 
 * @author hatrivedi
 * @date Nov 14, 2018
 * @since 2.5
 */
public class BullsAndCows {
	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int s = Character.getNumericValue(secret.charAt(i));
			int g = Character.getNumericValue(guess.charAt(i));
			if (s == g)
				bulls++;
			else {
				if (numbers[s] < 0)
					cows++;
				if (numbers[g] > 0)
					cows++;
				numbers[s]++;
				numbers[g]--;
			}
		}
		return bulls + "A" + cows + "B";
	}
}
