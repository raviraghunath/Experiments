package Experiment;

/*https://leetcode.com/problems/edit-distance/*/

public class MinEditDistance {

	public static void main(String[] args) {
		MinEditDistance minEditDistance = new MinEditDistance();
		String s1 = "h";
		String s2 = "r";
		System.out.println(minEditDistance.minDistance(s1, s2));
		System.out.println(minEditDistance.minDistance(s1, s2, 0, 0, 0));
		System.out.println(minEditDistance.minDistanceDp(s1, s2));
	}

	public int minDistanceDp(String word1, String word2) {
		int[][] cache = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				if (i == 0) {
					cache[i][j] = j;
				} else if (j == 0) {
					cache[i][j] = i;
				} else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					cache[i][j] = cache[i - 1][j - 1];
				} else {
					cache[i][j] = 1 + Math.min(cache[i][j - 1], Math.min(cache[i - 1][j], cache[i - 1][j - 1]));
				}
			}
		}
		return cache[word1.length()][word2.length()];
	}

	public int minDistance(String word1, String word2) {
		int[][] cache = new int[word1.length()][word2.length()];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
		return minDistance1(word1, word2, 0, 0, cache);
	}

	private int minDistance1(String word1, String word2, int i, int j, int[][] cache) {
		if (i == word1.length()) {
			return word2.length() - j;
		}
		if (j == word2.length()) {
			return word1.length() - i;
		}
		if (cache[i][j] != -1) {
			return cache[i][j];
		}
		int res = 0;
		if (word1.charAt(i) == word2.charAt(j)) {
			res = minDistance1(word1, word2, i + 1, j + 1, cache);
		} else {
			res = 1 + Math.min(minDistance1(word1, word2, i + 1, j + 1, cache),
					Math.min(minDistance1(word1, word2, i, j + 1, cache), minDistance1(word1, word2, i + 1, j, cache)));
		}
		cache[i][j] = res;
		return res;
	}

	private int minDistance(String word1, String word2, int i, int j, int count) {
		if (i == word1.length()) {
			return count + word2.length() - j;
		}
		if (j == word2.length()) {
			return count + word1.length() - i;
		}
		if (i == word1.length() || j == word2.length()) {
			if (word1.equals(word2)) {
				return count;
			} else {
				return Integer.MAX_VALUE;
			}
		}

		if (word1.charAt(i) == word2.charAt(i)) {
			return minDistance(word1, word2, i + 1, j + 1, count);
		} else {
			String wordTemp = "";
			int cnt1 = 0, cnt2 = 0, cnt3 = 0;

			// replace
			wordTemp = word1.substring(0, i) + word2.charAt(i) + word1.substring(i + 1);
			cnt1 = minDistance(wordTemp, word2, i + 1, j + 1, count + 1);

			// insert
			wordTemp = word1.substring(0, i) + word2.charAt(i) + word1.substring(i);
			cnt2 = minDistance(wordTemp, word2, i + 1, j + 1, count + 1);

			// delete
			wordTemp = word1.substring(0, i) + word1.substring(i + 1);
			cnt3 = minDistance(wordTemp, word2, i, j, count + 1);

			return Math.min(cnt1, Math.min(cnt2, cnt3));
		}

	}
}
