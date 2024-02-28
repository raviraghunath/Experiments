package Others;

public class Exp1 {

	static void printPermutn(String str, String ans) {

		// If string is empty
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) + str.substring(i + 1);

			// Recursive call
			printPermutn(ros, ans + ch);
		}
	}

	public static void swap(char[] arr, int idx, int idx2) {
		char temp = arr[idx];
		arr[idx] = arr[idx2];
		arr[idx2] = temp;
		System.out.print(String.valueOf(arr) + " ");
	}

	public static void solve(char[] arr, int idx) {
		if (idx == arr.length - 1) { // Base condition of recursion
			System.out.print(String.valueOf(arr) + " ");
		}

		for (int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			solve(arr, idx + 1);
			swap(arr, idx, i);

			System.out.println(new String(arr));
			// Backtracking: reverting all the elements to their original places
		}
	}

	public static void solve1(char[] arr, int idx) {
//		if (idx == arr.length - 1) { // Base condition of recursion
//			System.out.print(String.valueOf(arr) + " ");
//		}

		for (int j = idx; j < arr.length; j++) {
			for (int i = idx; i < arr.length; i++) {
				swap(arr, i, j);
//				solve(arr, idx + 1);
//				swap(arr, idx, i);

				// Backtracking: reverting all the elements to their original places
			}
		}
	}

	// Driver code
	public static void main(String[] args) {
		String s = "abc";
		// printPermutn(s, "");
		System.out.println();
		solve1(s.toCharArray(), 0);
	}
}
