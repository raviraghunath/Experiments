package Experiment;

public class CoinChange {

	public static void main(String[] args) {
		CoinChange coinChange = new CoinChange();
		System.out.println(coinChange.coinChange(new int[] { 1, 5, 6, 8 }, 11));
	}

	public int coinChange(int[] coins, int amount) {
		int[][] cache = new int[coins.length][amount + 1];
		int res = coinChange1(coins, amount, 0, cache);
		return res;
	}

	public int coinChange1(int[] coins, int amount, int i, int[][] cache) {
		if (amount == 0) {
			return 0;
		} else if (amount < 0) {
			return -1;
		} else if (i == coins.length) {
			return -1;
		}
		if (cache[i][amount] != 0) {
			return cache[i][amount];
		}
		int res1 = -1;
		if (amount / coins[i] > 0) {
			res1 = coinChange1(coins, amount - coins[i], i, cache);
			if (res1 != -1) {
				res1 = res1 + 1;
			}
		}
		int res2 = coinChange1(coins, amount, i + 1, cache);
		int res = res1 == -1 ? res2 : res2 == -1 ? res1 : Math.min(res1, res2);
		cache[i][amount] = res;
		return res;
	}

	public int coinChange(int[] coins, int amount, int i, int count) {
		if (amount == 0) {
			return count;
		} else if (amount < 0) {
			return -1;
		} else if (i == coins.length) {
			return -1;
		}
		int res1 = -1;
		if (amount / coins[i] > 0) {
			res1 = coinChange(coins, amount - coins[i], i, count + 1);
		}
		int res2 = coinChange(coins, amount, i + 1, count);
		int res = res1 == -1 ? res2 : res2 == -1 ? res1 : Math.min(res1, res2);
		return res;
	}
}
