package Strings;

import java.util.HashSet;

public class AllPermutationsOfString {

	public static void main(String[] args) {
		System.out.println(method1("abcde", 0).size());
		System.out.println(getPermutations("abcde").size());
	}

	private static HashSet<String> method1(String s, int pos) {
		HashSet<String> hashSet = new HashSet<String>();
		if (pos == s.length() - 1) {
			hashSet.add(s.substring(pos));
			return hashSet;
		}
		String s1 = String.valueOf(s.charAt(pos));
		HashSet<String> hashSet1 = method1(s, ++pos);
		for (String ss : hashSet1) {
			hashSet.addAll(getDifferentInsertedStrings(s1, ss));
		}
		return hashSet;
	}

	private static HashSet<String> getDifferentInsertedStrings(String s1, String s2) {
		HashSet<String> hashSet = new HashSet<String>();
		char[] charArray = s2.toCharArray();
		hashSet.add(s1 + s2);
		for (int i = 0, n = charArray.length; i < n; i++) {
			String s = s2.substring(0, i + 1) + s1 + s2.substring(i + 1);
			hashSet.add(s);
		}
		return hashSet;
	}

	private static HashSet<String> getPermutations(String str) {
		String s1 = str.substring(0, 1);
		String s2 = str.substring(1);
		HashSet<String> set = new HashSet<>();
		if (s2.length() > 1) {
			set = getPermutations(s2);
		} else {
			set.add(s2);
		}
		HashSet<String> set1 = new HashSet<>();
		for (String st : set) {
			set1.addAll(getDifferentInsertedStrings(s1, st));
		}
		return set1;
	}
}
