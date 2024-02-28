package Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* Given a set of non negative numbers and a total, find if there exists a  subset in this set whose sum is same as total.*/

public class SubSetSum {

	public static void main(String[] args) {
		SubSetSum setSum = new SubSetSum();
//		System.out.println(setSum.findSubSet(new int[] { 7, 3, 2, 5, 8 }, 14));
//		System.out.println(setSum.findSubSet(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 56));
//		System.out.println(setSum.findSubSet1(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 56));

		List<Integer> list = setSum.findSubSet2(new int[] { 12, 1, 61, 5, 9, 2 }, 24);
		System.out.println("***");
		for (Integer i : list) {
			System.out.print(i + ",");
		}
		System.out.println("\n***");

	}

	boolean findSubSet1(int[] arr, int tot) {
		boolean[][] dp = new boolean[arr.length][tot];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (arr[i] > j) {
					if (i == 0) {
						dp[i][j] = false;
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				} else if (arr[i] == j) {
					dp[i][j] = true;
				} else {
					if (i == 0) {
						dp[i][j] = false;
					} else {
						dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
					}
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + "   ");
			}
			System.out.println();
		}

		return dp[arr.length - 1][tot - 1];
	}

	boolean findSubSet(int[] arr, int tot) {
		return findSubSet(arr, tot, 0);
	}

	private Map<Te, Boolean> map = new HashMap<>();

	boolean findSubSet(int[] arr, int tot, int i) {
		if (map.containsKey(new Te(i, tot))) {
			return map.get(new Te(i, tot));
		}
		boolean res = false;
		if (tot == 0) {
			res = true;
		} else if (i == arr.length) {
			res = false;
		} else
			res = findSubSet(arr, tot - arr[i], i + 1) || findSubSet(arr, tot, i + 1);
		map.put(new Te(i, tot), res);
		return res;
	}

	List<Integer> findSubSet2(int[] arr, int tot) {
		return findSubSet2(arr, tot, 0, new ArrayList<>());
	}

	List<Integer> findSubSet2(int[] arr, int tot, int i, List<Integer> list) {
		if (tot == 0) {
			return list;
		} else if (i == arr.length) {
			return null;
		} else {
			List<Integer> list1 = findSubSet2(arr, tot, i + 1, list);
			if (null != list1) {
				return list1;
			} else {
				list1 = new ArrayList<>(list);
				list1.add(arr[i]);
				return findSubSet2(arr, tot - arr[i], i + 1, list1);
			}

		}
	}

}

class Te {
	int pos;
	int tot;

	Te(int pos, int tot) {
		this.pos = pos;
		this.tot = tot;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pos, tot);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Te other = (Te) obj;
		return pos == other.pos && tot == other.tot;
	}

}
