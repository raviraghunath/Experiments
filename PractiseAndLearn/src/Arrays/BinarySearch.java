package Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int [] array = {0,1,2,3,4,5,6,7,8,9,10};
		System.out.println(method1(array, 0, array.length-1, 8));
	}

	private static int method1(int array[], int st, int ed, int num) {
		if(st>ed)return -1;
		if (st == ed) {
			if (array[st] == num) {
				return st;
			} else {
				return -1;
			}
		}
		int mid = (st + ed) / 2;
		if (array[mid] > num)
			return method1(array, st, mid-1, num);
		else if (array[mid] < num)
			return method1(array, mid+1, ed, num);
		else
			return mid;
	}

}
