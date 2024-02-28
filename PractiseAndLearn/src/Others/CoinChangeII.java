package Others;

import java.util.Arrays;

/*https://leetcode.com/problems/coin-change-ii/*/
public class CoinChangeII {
	public static void main(String[] args) {
		CoinChangeII coinChangeII = new CoinChangeII();
		System.out.println(coinChangeII.change(11, new int[] { 1, 5, 6, 8 }));
	}

	public int change(int amount, int[] coins) {
		int[][] cache = new int[coins.length][amount + 1];
		for (int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		return change(amount, coins, 0, cache);
	}

	public int change(int amount, int[] coins, int pos, int[][] cache) {

		if (amount == 0) {
			return 1;
		}
		if (pos == coins.length) {
			return 0;
		}
		if (amount < 0) {
			return 0;
		}
		if (cache[pos][amount] != -1) {
			return cache[pos][amount];
		}
		int res = 0;
		if (amount / coins[pos] >= 0) {
			res += change(amount - coins[pos], coins, pos, cache);
		}
		res += change(amount, coins, pos + 1, cache);
		cache[pos][amount] = res;
		return res;
	}
}
