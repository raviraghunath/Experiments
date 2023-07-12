package Experiment;

import java.util.HashMap;
import java.util.Map;

/*https://leetcode.com/problems/longest-palindromic-subsequence/description/*/
public class LPS {

	public static void main(String[] args) {
		LPS lps = new LPS();
		System.out.println(lps.longestPalindromeSubseqDp("bbbab"));
		System.out.println(lps.longestPalindromeSubseq("bbbab"));
	}

	public int longestPalindromeSubseqDp(String s) {
		int dp[][] = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}
		int max = 1;
		for (int l = 2; l <= s.length() ; l++) {
			for (int i = 0; i < s.length() - l + 1; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j) && l == 2) {
					dp[i][j] = 2;
				} else if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				}
				if (s.charAt(i) == s.charAt(j)) {
					if (l == 2) {
						dp[i][j] = 2;
					} else {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					}
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
				if (max < dp[i][j]) {
					max = dp[i][j];
				}
			}
		}
		return max;
	}
	
	int lpsDp(String s) {
		int dp[][] = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}
		int max = 1;
		for (int l = 2; l <= s.length(); l++) {
			for (int i = 0; i < s.length() - l + 1; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j) && l == 2) {
					dp[i][j] = 2;
				} else if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
				if (max < dp[i][j]) {
					max = dp[i][j];
				}
			}
		}
		return max;
	}

	public int longestPalindromeSubseq(String s) {
		Map<Integer, Map<String, Integer>> cache = new HashMap<>();
		return longestPalindromeSubseq(s, 0, new StringBuilder(), cache);
	}

	public int longestPalindromeSubseq(String s, int i, StringBuilder currStr,
			Map<Integer, Map<String, Integer>> cache) {
		if (null != cache.get(i) && cache.get(i).get(currStr.toString()) != null) {
			return cache.get(i).get(currStr.toString());
		}
		if (i == s.length()) {
			return isPalindrome(currStr.toString()) ? currStr.length() : 0;
		}
		int res = Math.max(longestPalindromeSubseq(s, i + 1, new StringBuilder(currStr).append(s.charAt(i)), cache),
				longestPalindromeSubseq(s, i + 1, currStr, cache));
		Map<String, Integer> subMap = cache.get(i);
		if (subMap == null) {
			subMap = new HashMap<>();
			cache.put(i, subMap);
		}
		subMap.put(currStr.toString(), res);
		cache.put(i, subMap);
		return res;
	}

	private boolean isPalindrome(String s) {
		char[] chars = s.toCharArray();
		int j = chars.length - 1;
		for (int i = 0; i < chars.length / 2; i++, j--) {
			char t = chars[i];
			chars[i] = chars[j];
			chars[j] = t;
		}
		return new String(chars).equals(s);
	}

}
