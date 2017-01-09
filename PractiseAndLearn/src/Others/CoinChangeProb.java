package Others;

import java.io.IOException;
import java.util.Scanner;

/*Hacker Rank - The Coin Change Problem*/
//https://www.hackerrank.com/challenges/coin-change?h_r=next-challenge&h_v=zen
public class CoinChangeProb {
	/*
	 * 166 23 5 37 8 39 33 17 22 32 13 7 10 35 40 2 43 49 46 19 41 1 12 11 28
	 */

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int sum = in.nextInt();
		int size = in.nextInt();
		int[] inputList = new int[size];
		for (int i = 0; i < size; i++) {
			inputList[i] = in.nextInt();
		}
		long res = findCombination(inputList, 0, sum);
		System.out.println(res);
		in.close();
	}

	private static long findCombination(int[] inputList, int pos, int sum) {
		if (sum == 0) {
			return 1;
		} else if (sum < 0 || pos == inputList.length) {
			return 0;
		} else {
			int currEle = inputList[pos], times = sum / currEle, res = 0;
			for (int j = 0; j <= times; j++) {
				res += findCombination(inputList, pos + 1, sum - j * currEle);
			}
			return res;
		}
	}
}
