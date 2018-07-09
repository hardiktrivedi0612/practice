import java.util.HashSet;
import java.util.Set;

/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */

/**
 * 
 * 
 * You've built an inflight entertainment system with on-demand movie streaming.
 * 
 * Users on longer flights like to start a second movie right when their first
 * one ends, but they complain that the plane usually lands before they can see
 * the ending. So you're building a feature for choosing two movies whose total
 * runtimes will equal the exact flight length.
 * 
 * Write a method that takes an integer flightLength (in minutes) and an array
 * of integers movieLengths (in minutes) and returns a boolean indicating
 * whether there are two numbers in movieLengths whose sum equals flightLength.
 * 
 * When building your method:
 * 
 * Assume your users will watch exactly two movies Don't make your users watch
 * the same movie twice Optimize for runtime over memory
 * 
 * 
 * 
 * @author hatrivedi
 * @date Jun 12, 2018
 * @since 2.5
 */
public class Hash1 {

	/**
	 * @author hatrivedi
	 * @date Jun 12, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		int flightLength = 100;
		int[] movieslength = { 50, 60, 30, 80, 20 };
		boolean canUserWatchMovies = checkIfUserCanWatchMovies(flightLength, movieslength);
		System.out.println(canUserWatchMovies);
	}

	/**
	 * @author hatrivedi
	 * @date Jun 12, 2018
	 * @since 2.5
	 * @param flightLength
	 * @param movieslength
	 * @return
	 */
	private static boolean checkIfUserCanWatchMovies(int flightLength, int[] movieslength) {
//		HashMap<Integer, Integer> timeLeftMap = new HashMap<Integer, Integer>();
//		for (int i = 0; i < movieslength.length; i++) {
//			timeLeftMap.put((flightLength - movieslength[i]), i);
//		}
//		for (int i = 0; i < movieslength.length; i++) {
//			if (timeLeftMap.containsKey(movieslength[i]) && timeLeftMap.get(movieslength[i]) != i)
//				return true;
//		}
		
		Set<Integer> timeLeftSet = new HashSet<>();
		for(int movieLength : movieslength)
		{
			int flightTimeLeft = flightLength - movieLength;
			if(timeLeftSet.contains(flightTimeLeft))
				return true;
			timeLeftSet.add(movieLength);
		}
		
		return false;
	}

}
