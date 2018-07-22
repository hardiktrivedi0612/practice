package com.trivedi.hardik.interviewcake;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author hatrivedi
 * @date Apr 18, 2018
 * @since 2.5
 */
public class Question5 {

	private static Map<String, Integer> memo = new HashMap<>();

	public static void main(String args[]) {
		
		//Recursive bottom up approach
		int amount = 4;
		int[] denominations = { 3, 1, 2 };
		System.out.println(countPossibilities(amount, denominations));

	}

	public static int countPossibilities(int amount, int[] denominations) {
		return countPossibilities(amount, denominations, 0);
	}

	public static int countPossibilities(int amountLeft, int[] denominations, int currentIndex) {
		
		System.out.printf("TOP => checking ways to make %d with %s\n", amountLeft,
				Arrays.toString(Arrays.copyOfRange(denominations, currentIndex, denominations.length)));

		String memoKey = amountLeft + "," + currentIndex;
		if (memo.containsKey(memoKey)) {
			System.out.println("grabbing memo [" + memoKey + "]");
			return memo.get(memoKey);
		}

		// Exact match
		if (amountLeft == 0)
			return 1;

		// Over shot
		if (amountLeft < 0)
			return 0;

		if (currentIndex == denominations.length)
			return 0;

//		System.out.printf("checking ways to make %d with %s\n", amountLeft,
//				Arrays.toString(Arrays.copyOfRange(denominations, currentIndex, denominations.length)));

		int currentCoin = denominations[currentIndex];

		int numPossibilities = 0;

		while (amountLeft >= 0) {
			numPossibilities += countPossibilities(amountLeft, denominations, currentIndex + 1);
			amountLeft -= currentCoin;
		}

		System.out.println("Adding to memo key = " + memoKey + " values = " + numPossibilities);
		memo.put(memoKey, numPossibilities);

		return numPossibilities;

	}
}
