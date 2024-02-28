package Others;
public class OptimalBST {

	public static void main(String[] args) {
		int keys[] = { 10, 12, 20 };
		int freq[] = { 34, 8, 50 };
		int n = keys.length;
		OptimalBST optimalBST = new OptimalBST();
		System.out.println("Cost of Optimal BST is " + OptimalBST.optCost(freq, 0, n - 1));
		System.out.println("Cost of Optimal BST is " + optimalBST.minCost(keys, freq, 0, n - 1));
	}

	int minCost(int node[], int weight[], int index, int end) {

		if (end < index) {
			return 0;
		}

		if (index == end) {
			return weight[index];
		}

		int rootVal = sum(weight, index, end);

		int min = Integer.MAX_VALUE;

		for (int i = index; i <= end; i++) {
			int res = minCost(node, weight, index, i - 1) + minCost(node, weight, i + 1, end);
			if (res < min)
				min = res;
		}

		int res = rootVal + min;
		return res;

	}

	static int optCost(int freq[], int i, int j) {
		// Base cases
		if (j < i) // no elements in this subarray
			return 0;
		if (j == i) // one element in this subarray
			return freq[i];

		// Get sum of freq[i], freq[i+1], ... freq[j]
		int fsum = sum(freq, i, j);

		// Initialize minimum value
		int min = Integer.MAX_VALUE;

		// One by one consider all elements as root and
		// recursively find cost of the BST, compare the
		// cost with min and update min if needed
		for (int r = i; r <= j; ++r) {
			int cost = optCost(freq, i, r - 1) + optCost(freq, r + 1, j);
			if (cost < min)
				min = cost;
		}

		// Return minimum value
		return min + fsum;
	}

	static int sum(int freq[], int i, int j) {
		int s = 0;
		for (int k = i; k <= j; k++)
			s += freq[k];
		return s;
	}

}
