package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeastNumOfCoinsRequired {

	static int A[] = new int[] { 1, 5, 10, 25, 50 };

	public static void main(String[] args) {
		List<Integer> list = m1(78);
		System.out.println(list);
	}

	private static List<Integer> m1(int m) {
		if (m == 0)
			return new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if (m != 0) {
			list.addAll(m1(m - 1));
		}
		if (isPresent(A, m)) {
			list.add(m);
		} else if (!isSumPresent(list, m, 0)) {
			list.add(A[0]);
		}
		return list;
	}

	private static boolean isPresent(int a[], int m) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == m)
				return true;
		}
		return false;
	}

	private static boolean isSumPresent(List<Integer> a, int m, int i) {
		if (a.size() == 1) {
			return a.get(0) == m;
		}
		if (m == 0)
			return true;
		if (i == a.size())
			return false;
		return isSumPresent(a, m - a.get(i), i + 1) || isSumPresent(a, m - 0, i + 1);

	}

}
