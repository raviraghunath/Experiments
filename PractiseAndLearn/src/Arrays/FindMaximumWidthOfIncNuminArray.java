package Arrays;

/**
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
 * https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 * 
 * @author rravindranathan
 *
 */
public class FindMaximumWidthOfIncNuminArray {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 4, 3, 2, 1 };
		System.out.println(maxIndexDiff(arr));
	}

	private static int maxIndexDiff(int[] arr) {
		int lArr[] = new int[arr.length];

		lArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (lArr[i - 1] > arr[i]) {
				lArr[i] = arr[i];
			} else {
				lArr[i] = lArr[i - 1];
			}
		}

		int rArr[] = new int[arr.length];
		rArr[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (rArr[i + 1] < arr[i]) {
				rArr[i] = arr[i];
			} else {
				rArr[i] = rArr[i + 1];
			}
		}

		int max = -1;
		int i = 0;
		int j = 0;
		while (i < arr.length && j < arr.length) {
			if (lArr[i] < rArr[j]) {
				int diff = j - i;
				max = diff < max ? max : diff;
				j++;
			} else {
				i++;
			}
		}
		return max;
	}

}
