package Experiment;

public class LCS {
	public static void main(String[] args) {
		LCS lcs = new LCS();
		// System.out.println(lcs.longestCommonSubsequence("abc", "def"));
		System.out.println(lcs.longestCommonSubsequence1("bsbininm", "jmjkbkjkv"));
	}

	public int longestCommonSubsequence(String text1, String text2) {
		int[][] cache = new int[text1.length()][text2.length()];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
		return longestCommonSubsequence(text1, text2, 0, 0, cache);
	}

	public int longestCommonSubsequence(String text1, String text2, int i, int j, int[][] cache) {
		if (text1.length() == i || text2.length() == j) {
			return 0;
		}
		if (cache[i][j] != -1) {
			return cache[i][j];
		}
		int res = 0;
		if (text1.charAt(i) == text2.charAt(j)) {
			res = 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1, cache);
		} else {
			res = Math.max(longestCommonSubsequence(text1, text2, i, j + 1, cache),
					longestCommonSubsequence(text1, text2, i + 1, j, cache));
		}
		cache[i][j] = res;
		return res;
	}

	public int longestCommonSubsequence1(String text1, String text2) {
		int[][] cache = new int[text1.length()][text2.length()];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					if (i == 0 || j == 0)
						cache[i][j] = 1;
					else
						cache[i][j] = 1 + cache[i - 1][j-1];
				} else {
					if (i == 0 && j == 0) {
						cache[i][j] = 0;
					} else if (i == 0) {
						cache[i][j] = cache[i][j - 1];
					} else if (j == 0) {
						cache[i][j] = cache[i - 1][j];
					} else {
						cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
					}
				}
			}
		}

		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				System.out.print(cache[i][j] + "   ");
			}
			System.out.println();
		}

		return cache[text1.length() - 1][text2.length() - 1];
	}

}
