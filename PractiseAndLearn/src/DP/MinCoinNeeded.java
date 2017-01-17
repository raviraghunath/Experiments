package DP;

import java.util.ArrayList;

/*https://www.youtube.com/watch?v=NJuKJ8sasGk&t=141s
*/
public class MinCoinNeeded {

	public static void main(String[] args) {
		int[] val = { 7, 2, 3, 6 };
		formMatrix(val, 13);

	}

	private static void formMatrix(int[] val, int maxVal) {
		int[][] matrix = new int[val.length][maxVal + 1];
		int infinityValHere = maxVal * 2;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j == 0) {
					matrix[i][j] = 0;
					continue;
				}
				if (i == 0) {
					if (j >= val[i])
						matrix[i][j] = 1 + matrix[i][j - val[i]];
					else
						matrix[i][j] = infinityValHere;
					continue;
				}
				if (j < val[i]) {
					matrix[i][j] = matrix[i - 1][j];
					continue;
				}
				matrix[i][j] = Math.min(matrix[i - 1][j], 1 + matrix[i][j - val[i]]);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		int i = matrix.length - 1, j = maxVal;
		ArrayList<Integer> res = new ArrayList<>();
		while (i >= 0 && j >= 0) {
			if (i == 0 && matrix[i][j] < infinityValHere) {
				res.add(val[i]);
				j = j - val[i];
				i = i - 1;
				continue;
			}
			System.out.println(i + "," + j);
			if (matrix[i - 1][j] == matrix[i][j]) {
				i = i - 1;
			} else {
				res.add(val[i]);
				j = j - val[i];
				i = i - 1;
			}
		}
		System.out.println(res);
	}
}
