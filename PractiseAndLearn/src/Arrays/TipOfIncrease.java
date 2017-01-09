package Arrays;

public class TipOfIncrease {

	public static void main(String[] args) {
		int arr[] = { 1000, 100, 90, 80, 70, 60, 50, 45, 35 };
		System.out.println(arr[method(arr, 0, arr.length - 1)]);
	}

	private static int method(int[] arr, int i, int j) {
		if (i == j)
			return i;
		int mid = (i + j) / 2;
		System.out.println(i + "," + mid + "," + j);
		if (arr[mid] <= arr[mid + 1])
			return method(arr, mid + 1, j);
		else
			return method(arr, i, mid);
	}
}
