package Others;
public class KnapSack {

	public static void main(String[] args) {
		KnapSack knapSack = new KnapSack();
//		System.out.println(knapSack.findMax(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 0, 7, 0, 0));
		System.out.println(knapSack.findMax(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 7));
//		System.out.println(knapSack.findTargetSumWays(new int[] { 1 }, 1));
	}

	private int findMax(int[] wts, int[] values, int i, int wt, int currWt, int currVal) {
		if (i == wts.length) {
			return 0;
		}
		if (currWt == wt) {
			return currVal;
		}
		return Math.max(findMax(wts, values, i + 1, wt, currWt, currVal),
				findMax(wts, values, i + 1, wt, currWt + wts[i], currVal + values[i]));
	}

	private int findMax(int[] wts, int[] values, int wt) {
		int[][] dp = new int[wts.length][wt + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (j < wts[i]) {
					if (i == 0) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				} else {
					if (i == 0) {
						dp[i][j] = values[i];
					} else {
						dp[i][j] = Math.max(values[i] + dp[i - 1][j - wts[i]], dp[i - 1][j]);
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
		return dp[wts.length - 1][wt];

	}

	/* https://leetcode.com/problems/target-sum/description/ */
	public int findTargetSumWays(int[] nums, int target) {
		return findTargetSumWays(nums, target, 0);
	}

	public int findTargetSumWays(int[] nums, int target, int i) {
		if (i == nums.length) {
			if (target == 0) {
				return 1;
			}
			return 0;
		}

		return findTargetSumWays(nums, target - nums[i], i + 1) + findTargetSumWays(nums, target + nums[i], i + 1);
	}
}
