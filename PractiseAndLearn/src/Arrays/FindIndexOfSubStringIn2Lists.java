package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindIndexOfSubStringIn2Lists {

	public static void main(String[] args) throws IOException {
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter length of the List 1 ");
		String s = br.readLine();
		int l1Len = Integer.parseInt(s);
		for (int i = 1; i <= l1Len; i++) {
			s = br.readLine();
			l1.add(s);
		}
		System.out.println("Enter length of the List 2 ");
		s = br.readLine();
		int l2Len = Integer.parseInt(s);
		for (int i = 1; i <= l2Len; i++) {
			s = br.readLine();
			l2.add(s);
		}
		System.out.println("Output is :" + find(l1, l2));
	}

	private static int find(List<String> l1, List<String> l2) {
		int j = 0, st = -1;
		for (int i = 0; i < l1.size(); i++) {
			if (l1.get(i).equals(l2.get(j))) {
				if (st == -1)
					st = i;
				j++;
			} else {
				st = -1;
				j = 0;
			}
			if (j == l2.size())
				return st;
		}
		return -1;
	}
}
