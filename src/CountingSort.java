
public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public int[] countingSort(int[] theArray, int maxValue) {
		int numCounts[] = new int[maxValue + 1];
		for (int i : theArray) {
			numCounts[i]++;
		}
		int sortedArray[] = new int[theArray.length];
		int z = 0;
		for (int i = 0; i < theArray.length; i++) {
			if (numCounts[i] > 0) {
				for (int j = 0; j < numCounts[i]; j++) {
					sortedArray[z++] = i;
				}
			}
		}
		return sortedArray;
	}

}
