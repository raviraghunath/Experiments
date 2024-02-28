package Others;

import java.util.HashMap;
import java.util.Map;

public class CLimbingStairs {

	public static void main(String[] args) {
		CLimbingStairs cLimbingStairs = new CLimbingStairs();
		int n = 45;
		Map<Integer, Integer> cache = new HashMap<>();
		System.out.println(cLimbingStairs.climbStairs(n, cache));
		System.out.println(cLimbingStairs.climbStairs1(n));
	}

	public int climbStairs(int n, Map<Integer, Integer> cache) {
		if (cache.get(n) != null) {
			return cache.get(n);
		}

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int res = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
		cache.put(n, res);
		return res;

	}

	public int climbStairs1(int n) {
		if (n <= 0 && n >= 3) {
			return n;
		}
		int p1 = 2;
		int p2 = 3;
		int p3 = 0;
		for (int i = 4; i <= n; i++) {
			p3 = p2 + p1;
			p1 = p2;
			p2 = p3;
		}
		return p3;
	}
}
