package DP;

//https://medium.com/@SilentFlame/leetcode-paint-house-dynamic-programming-9253c3b5687c
public class PaintHouses {

	public static void main(String[] args) {
		PaintHouses paintcost = new PaintHouses();
		int n = 3;
		int cost[][] = { { 14, 2, 11 }, { 11, 14, 5 }, { 14, 3, 10 } };
		System.out.println(paintcost.dp(n, cost));
		System.out.println(paintcost.dp_1(n, cost));
		System.out.println(paintcost.dp_2(n, cost));
	}

	// Time : O(N) & Space : O(1)
	private int dp_2(int n, int[][] cost) {
		int a = cost[0][0];
		int b = cost[0][1];
		int c = cost[0][2];

		for (int i = 1; i < cost.length; i++) {
			int a1, b1, c1;
			a1 = Math.min(b, c) + cost[i][0];
			b1 = Math.min(a, c) + cost[i][1];
			c1 = Math.min(a, b) + cost[i][2];
			a = a1;
			b = b1;
			c = c1;
		}

		return Math.min(a, Math.min(b, c));
	}

	// Time : O(N) & Space : O(N)
	private int dp_1(int n, int[][] cost) {
		int dp[][] = new int[cost.length][3];
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];

		for (int i = 1; i < cost.length; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
		}

		return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
	}

	// Time : O(3^N) & Space : O(1)
	private int dp(int n, int[][] cost) {

		int min = Integer.MAX_VALUE;
		for (int j = 0; j < 3; j++) {
			int val = dp(cost, 0, j);
			if (val < min) {
				min = val;
			}
		}

		return min;
	}

	private int dp(int[][] cost, int i, int j) {
		if (i == cost.length) {
			return 0;
		}
		int a = 0;
		int b = 0;
		if (j == 0) {
			a = 1;
			b = 2;
		}
		if (j == 1) {
			a = 0;
			b = 2;
		}
		if (j == 2) {
			a = 0;
			b = 1;
		}
		return cost[i][j] + Math.min(dp(cost, i + 1, a), dp(cost, i + 1, b));
	}

}
