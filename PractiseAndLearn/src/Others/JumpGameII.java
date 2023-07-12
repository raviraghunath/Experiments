package Experiment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII jumpGameII = new JumpGameII();
//		System.out.println(jumpGameII.jump(new int[] { 5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7,
//				9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5 }));
		System.out.println(jumpGameII.jump1(new int[] { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 }));
	}

	public int jump(int[] nums) {
		Map<Integer, Integer> cache = new HashMap<>();
		return jump(nums, 0, cache);
	}

	public int jump(int[] nums, int pos, Map<Integer, Integer> cache) {
		if (cache.get(pos) != null) {
			return cache.get(pos);
		}
		if (pos >= nums.length) {
			return -1;
		}
		if (pos == nums.length - 1) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= nums[pos]; i++) {
			int res = jump(nums, pos + i, cache);
			if (res != -1) {
				if (res < min) {
					min = res;
				}
			}
		}
		int res = min == Integer.MAX_VALUE ? -1 : 1 + min;
		cache.put(pos, res);
		return res;
	}

	public int jump1(int[] nums) {

		int[] dp = new int[nums.length];
		dp[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i) {
					int r = dp[j] + 1;
					if (r < min)
						min = r;
				}
			}
			dp[i] = min;
		}
		return dp[nums.length - 1];
	}
}
