package Experiment;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

	public static void main(String[] args) {
		LongestSubString longestSubString = new LongestSubString();
		System.out.println(longestSubString.lengthOfLongestSubstring("bbtablud"));
	}

	public int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> map = new HashMap<>();

		int i = 0;
		int curLen = 0;
		int maxLen = 0;
		int curStart = 0;
		while (i < s.length()) {
			if (map.containsKey(s.charAt(i))) {
				if (curLen > maxLen) {
					maxLen = curLen;
				}
				int i1 = map.get(s.charAt(i));
				for (int j = curStart; j <= i1; j++) {
					map.remove(s.charAt(j));
				}
				curStart = i1 + 1;
				curLen = i - curStart + 1;
				map.put(s.charAt(i), i);
			} else {
				curLen++;
				map.put(s.charAt(i), i);
			}
			i++;
		}
		if (curLen > maxLen) {
			maxLen = curLen;
		}
		return maxLen;

	}

}
