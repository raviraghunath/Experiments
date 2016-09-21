package Arrays;

public class MoveAndHop {

	public static void main(String[] args) {
		int a[] = new int[] { 1, 1, 1, 1, 1, 4, 1, 1, 1, 1 };
		System.out.println(method1(a, 0));
	}

	private static int method1(int a[], int pos) {
		if (pos == a.length - 1)
			return 1;
		if (pos >= a.length)
			return pos;
		return Math.min(1 + method1(a, 1 + pos), 1 + method1(a, pos + a[pos]));
	}

}
