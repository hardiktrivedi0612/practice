import java.util.Arrays;

/**
 * In order to win the prize for most cookies sold, my friend Alice and I are
 * going to merge our Girl Scout Cookies orders and enter as one unit.
 * 
 * Each order is represented by an "order id" (an integer).
 * 
 * We have our lists of orders sorted numerically already, in arrays. Write a
 * method to merge our arrays of orders into one sorted array.
 * 
 * @author hatrivedi
 * @date Jun 10, 2018
 * @since 2.5
 */
public class Arrays4 {
	public static void main(String args[]) {
		int[] myArray = new int[] { 3, 4, 6, 10, 11, 15 };
		int[] alicesArray = new int[] { 1, 5, 8, 12, 14, 19 };

		System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));

	}

	/**
	 * @author hatrivedi
	 * @date Jun 10, 2018
	 * @since 2.5
	 * @param myArray
	 * @param alicesArray
	 * @return
	 */
	private static int[] mergeArrays(int[] myArray, int[] alicesArray) {
		int[] mergedArrays = new int[myArray.length + alicesArray.length];
		int myPointer = 0;
		int alicesPointer = 0;
		for (int i = 0; i < mergedArrays.length; i++) {
			boolean isMyArrayExhausted = myPointer >= myArray.length;
			boolean isAlicesArrayExhausted = alicesPointer >= alicesArray.length;
			if (!isMyArrayExhausted && (isAlicesArrayExhausted || myArray[myPointer] <= alicesArray[alicesPointer])) {
				mergedArrays[i] = myArray[myPointer++];
			} else {
				mergedArrays[i] = alicesArray[alicesPointer++];
			}
		}
		return mergedArrays;
	}
}
