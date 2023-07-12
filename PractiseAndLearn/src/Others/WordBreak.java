package Experiment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args) {
		WordBreak wordBreak = new WordBreak();
		String[] strs = new String[] { "leet", "code" };
		List<String> strings = Arrays.asList(strs);
		System.out.println(wordBreak.wordBreak("leetcode", strings));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		int[][] cache = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			Arrays.fill(cache[i], -1);
		}
		return wordBreak(s, new HashSet(wordDict), 0, 0, cache);
	}

	public boolean wordBreak(String s, Set<String> wordDict, int start, int pos, int[][] cache) {
		if (cache[start][pos] != -1) {
			return cache[start][pos] == 1 ? true : false;
		}
		if (s.length() - 1 == pos) {
			return wordDict.contains(s.substring(start));
		}
		boolean b1 = wordBreak(s, wordDict, start, pos + 1, cache);
		boolean b2 = false;
		if (wordDict.contains(s.substring(start, pos + 1))) {
			b2 = wordBreak(s, wordDict, pos + 1, pos + 1, cache);
		}
		boolean b = b1 || b2;
		cache[start][pos] = b ? 1 : 0;
		return b;
	}

}
