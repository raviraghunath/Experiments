package Arrays;

public class FindNumberWhichRepeats3 {

	static int addNumbers(int a, int b) {
		return a + b;
	}

	static int find(int[] arr) {
		if (arr == null) {
			return -1;
		}
		if (arr.length % 2 == 0) {
			return -1;
		}
		return find(arr, 0, arr.length - 1);
	}

	static int find(int[] arr, int st, int ed) {
		int mid = st + (ed - st) / 2;
		if(mid < 0 || mid > arr.length-1) {
			return -1;
		}
		if ((mid != 0 || mid != arr.length - 1) && arr[mid - 1] == arr[mid] && arr[mid + 1] == arr[mid]) {
			return arr[mid];
		}
		if ((mid + 1) % 2 == 0) {
			if (arr[mid - 1] != arr[mid]) {
				return find(arr, st, mid - 1);
			} else {
				return find(arr, mid + 1, ed);
			}
		} else {
			if (arr[mid + 1] != arr[mid]) {
				return find(arr, mid + 1, ed);
			} else {
				return find(arr, st, mid - 1);
			}

		}
	}

	// [2,2,4,4,4,5,5,8,8,9,9]
	// arr 0 10
	// mid = 5
	// arr 0 4
	// mid = 2

	public static void main(String[] args) {
		System.out.println(find(new int[] { 2, 2, 4, 4, 4, 5, 5, 8, 8, 9, 9 }));
	}

}
