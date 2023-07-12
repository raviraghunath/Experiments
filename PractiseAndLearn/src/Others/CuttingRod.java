package Experiment;

public class CuttingRod {

	public static void main(String[] args) {
		CuttingRod cuttingRod = new CuttingRod();
		System.out.println(cuttingRod.minCost(7, new int[] { 1, 3, 4, 5 }));
	}

	public int minCost(int n, int[] cuts) {
		return minCost(n, cuts, 0, 0, n);
	}

	public int minCost(int n, int[] cuts, int i, int start, int end) {
		System.out.println(i + "-" + start + "-" + end);
		if (i == cuts.length) {
			return -1;
		}
		if (start >= cuts[i] || end <= cuts[i]) {
			return -1;
		}
		int len = end - start;
		System.out.println("Len : " + len);
		if (len == 1) {
			return -1;
		}
		int cost1 = len;
		int temp = minCost(n, cuts, i + 1, start, cuts[i]);
		if (temp != -1) {
			len += temp;
		}
		temp = minCost(n, cuts, i + 1, cuts[i], end);
		if (temp != -1) {
			len += temp;
		}
		int cost2 = minCost(n, cuts, i + 1, start, end);
		return cost2 != -1 ? Math.min(cost1, cost2) : cost1;
	}

}
