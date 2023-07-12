package Experiment;

public class BestTimeToBuyStock {

	public static void main(String[] args) {

		BestTimeToBuyStock bestTimeToBuyStock = new BestTimeToBuyStock();
		System.out.println(bestTimeToBuyStock.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	public int maxProfit(int[] prices) {
		return maxProfit(prices, 0, 0, 0);

	}

	public int maxProfit(int[] prices, int i, int amount, int currHoldAmt) {
		if (i == prices.length) {
			return amount;
		}
		if (currHoldAmt == 0) {
			return Math.max(maxProfit(prices, i + 1, amount - prices[i], prices[i]),
					maxProfit(prices, i + 1, amount, 0));
		} else {
			return Math.max(maxProfit(prices, i + 1, amount + prices[i] - currHoldAmt, 0),
					maxProfit(prices, i + 1, amount, 0));
		}

	}

	public int maxProfit1(int[] prices) {
		int min = Integer.MAX_VALUE;
		int profit = Integer.MIN_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
			}
			profit = Math.max(profit, prices[i] - min);
		}
		return profit;
	}
}
