import java.util.Arrays;
import java.util.Random;

/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */

/**
 * 
 * 
 * Write a method for doing an in-place ↴ shuffle of an array.
 * 
 * The shuffle must be "uniform," meaning each item in the original array must
 * have the same probability of ending up in each spot in the final array.
 * 
 * Assume that you have a method getRandom(floor, ceiling) for getting a random
 * integer that is >= floor and <= ceiling.
 * 
 * @author hatrivedi
 * @date Jun 30, 2018
 * @since 2.5
 */
public class Greedy4 {

	/**
	 * @author hatrivedi
	 * @date Jun 30, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		final int[] initial = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		final int[] shuffled = Arrays.copyOf(initial, initial.length);
		shuffle(shuffled);
		System.out.printf("initial array: %s\n", Arrays.toString(initial));
		System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
	}

	private static Random rand = new Random();

	private static int getRandom(int floor, int ceiling) {
		return rand.nextInt((ceiling - floor) + 1) + floor;
	}

	public static void shuffle(int[] theArray) {
		
	}

}
