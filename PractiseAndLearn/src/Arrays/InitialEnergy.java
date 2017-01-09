package Arrays;

/*http://www.geeksforgeeks.org/minimum-initial-energy-required-to-cross-street/
*/
public class InitialEnergy {

	public static void main(String[] args) {
		int n = method1(new int[] { 4, -10, 4, 4, 4 });
		System.out.println(n);
	}

	private static int method1(int[] arr) {
		int min = 1;
		boolean firstPosNeglect = true;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (firstPosNeglect && arr[i] > 0) {
				continue;
			}
			firstPosNeglect = false;
			min = min - arr[i];
			if (min <= 0)
				min = 1;
		}
		return min;
	}

}
