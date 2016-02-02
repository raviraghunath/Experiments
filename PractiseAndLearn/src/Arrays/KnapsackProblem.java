package Arrays;

public class KnapsackProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] wt = {2,2,4,5};
		int [] bt = {3,7,2,9};
		int val = m1(0, wt, bt, 13);
		System.out.println(val);
	}
	private static int m1(int index, int[] wt, int[] bt, int TW) {
		if (index == wt.length) {
			return 0;
		}
		int b = bt[index];
		int w = wt[index];
		++index;
		int val1 = 0;
		if(w<=TW){
			val1=b + m1(index, wt, bt, TW - w);
		}
		int val2 = 0 + m1(index, wt, bt, TW);
		return Math.max(val1, val2);
	}

}
