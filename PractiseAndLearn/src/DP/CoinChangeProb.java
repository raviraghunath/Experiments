package DP;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/coin-change?h_r=next-challenge&h_v=zen
public class CoinChangeProb {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int sum = in.nextInt();
		int size = in.nextInt();
		int[] coins = new int[size];
		for (int i = 0; i < size; i++) {
			coins[i] = in.nextInt();
		}
		Arrays.sort(coins);
		sum++;
		long[][] t = new long[size][sum];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < sum; j++) {
				if (i == 0) {
					if (j == 0) {
						t[i][j] = 1;
					} else {
						t[i][j] = (j % coins[i] == 0) ? 1 : 0;
					}
					continue;
				}
				if (j >= coins[i]) {
					t[i][j] = t[i - 1][j] + t[i][j - coins[i]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		
		System.out.println(t[size - 1][sum - 1]);
	}
}
