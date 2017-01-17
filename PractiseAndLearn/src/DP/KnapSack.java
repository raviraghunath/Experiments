package DP;

import java.util.ArrayList;

/*https://www.youtube.com/watch?v=8LusJS5-AGo
*/
public class KnapSack {

	public static void main(String[] args) {
		int[] wt = { 5, 4, 6, 3 };
		int[] val = { 10, 40, 30, 50 };
		formMatrix(wt, val, 10);
	}

	private static void formMatrix(int[] wt, int[] val, int maxWt) {
		int[][] matrix = new int[val.length][maxWt + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j == 0) {
					matrix[i][j] = 0;
					continue;
				}
				if (i == 0) {
					matrix[i][j] = 1;
					continue;
				}
				if (j < wt[i]) {
					matrix[i][j] = matrix[i - 1][j];
					continue;
				}
				matrix[i][j] = Math.max(val[i] + matrix[i - 1][j - wt[i]], matrix[i - 1][j]);
			}
		}
		int i = matrix.length - 1, j = maxWt;
		ArrayList<Integer> res = new ArrayList<>();

		while (i > 0 && j > 0) {
			if (matrix[i - 1][j] == matrix[i][j]) {
				i = i - 1;
			} else {
				res.add(wt[i]);
				j = j - wt[i];
				i = i - 1;
			}
		}
		System.out.println(res);
	}

}
