package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GroupAllAnagramsTogetherSet implements Comparator<String> {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("abcd", "abc", "abce", "acd", "abdc"));
		method1(list);
	}

	private static void method1(ArrayList<String> list) {
		System.out.println(list);
		Collections.sort(list, new GroupAllAnagramsTogetherSet());
		System.out.println(list);
	}

	@Override
	public int compare(String o1, String o2) {
		char[] c1 = o1.toCharArray();
		char[] c2 = o2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);

		String s1 = new String(c1);
		String s2 = new String(c2);

		return s1.compareTo(s2);
	}

}
