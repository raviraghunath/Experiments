package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class BuyNSellStock1 {

	public static void main(String[] args) {
		int price[] = { 100, 80, 120, 130, 70, 60, 100, 125 };
		method1(price);
		method1(price);
	}

	private static void method1(int[] price) {
		if (price == null || price.length < 2) {
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		int max = 0;
		for (int i = 0, n = price.length; i < n; i++) {
			int ele = price[i];
			if (ele < max) {
				queue.add(max);
			}
			max = ele;
			if(i==n-1)queue.add(max);
		}
		int maxDiff = 0;
		for (int i = 0, n = price.length; i < n; i++) {
			if(queue.isEmpty()){break;}
			int diff = queue.peek() - price[i];
			if (maxDiff < diff)
				maxDiff = diff;
			if (price[i] == queue.peek()) {
				queue.poll();
			}
		}
		System.out.println(maxDiff);
	}

	private static void method2(int[] price) {
		if (price == null || price.length < 2) {
			return;
		}
		int profit =0;
	    int minValue = Integer.MAX_VALUE;
		for (int i = 0, n = price.length; i < n; i++) {
			profit=Math.max(profit, price[i]-minValue);
			minValue=Math.min(minValue, price[i]);
		}
		System.out.println(profit);
	}

}
