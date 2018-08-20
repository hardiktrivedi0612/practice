package com.trivedi.hardik.interviewcake;

/**
 * 
 * You created a game that is more popular than Angry Birds.
 * 
 * Each round, players receive a score between 0 and 100, which you use to rank
 * them from highest to lowest. So far you're using an algorithm that sorts in
 * O(nlgn)O(n\lg{n})O(nlgn) time, but players are complaining that their
 * rankings aren't updated fast enough. You need a faster sorting algorithm.
 * 
 * Write a method that takes:
 * 
 * an array of unsortedScores the highestPossibleScore in the game
 * 
 * and returns a sorted array of scores in less than O(nlgn)O(n\lg{n})O(nlgn)
 * time.
 * 
 * For example:
 * 
 * int[] unsortedScores = {37, 89, 41, 65, 91, 53}; final int
 * HIGHEST_POSSIBLE_SCORE = 100;
 * 
 * int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE); //
 * sortedScores: [91, 89, 65, 53, 41, 37]
 * 
 * We’re defining nnn as the number of unsortedScores because we’re expecting
 * the number of players to keep climbing.
 * 
 * And we'll treat highestPossibleScore as a constant instead of factoring it
 * into our big O time and space costs, because the highest possible score isn’t
 * going to change. Even if we do redesign the game a little, the scores will
 * stay around the same order of magnitude.
 * 
 * @author hatrivedi
 * @date Jun 24, 2018
 * @since 2.5
 */
public class TopScoreSortingGivenN {

	/**
	 * @author hatrivedi
	 * @date Jun 24, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] unsortedScores = { 37, 89, 41, 65, 91, 53 };
		final int HIGHEST_POSSIBLE_SCORE = 100;
		int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
		for(int i = 0; i < sortedScores.length ; i++)
		{
			System.out.println(sortedScores[i]);
		}
	}

	/**
	 * @author hatrivedi
	 * @date Jun 27, 2018
	 * @since 2.5
	 * @param unsortedScores
	 * @param hIGHEST_POSSIBLE_SCORE
	 * @return
	 */
	private static int[] sortScores(int[] unsortedScores, int hIGHEST_POSSIBLE_SCORE) {
		int[] scoreCount = new int[hIGHEST_POSSIBLE_SCORE + 1];
		for (int score : unsortedScores) {
			scoreCount[score]++;
		}
		int sortedScores[] = new int[unsortedScores.length];
		int j = 0;
		for (int i = hIGHEST_POSSIBLE_SCORE; i >= 0; i--) {
			if (scoreCount[i] > 0) {
				for (int k = 0; k < scoreCount[i]; k++) {
					sortedScores[j++] = i;
				}
			}
		}
		return sortedScores;
	}

}
