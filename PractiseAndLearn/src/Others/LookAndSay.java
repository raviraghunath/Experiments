package Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LookAndSay {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(LookAndSayMd(Long.parseLong(br.readLine())));
	}

	private static String LookAndSayMd(long l) {
		StringBuilder s = new StringBuilder("");
		String inp = String.valueOf(l);
		char[] ch = inp.toCharArray();

		int cnt = 1;
		for (int i = 0; i < ch.length; i++) {
			if (i < ch.length - 1 && ch[i] == ch[i + 1]) {
				cnt++;
			} else {
				s.append(cnt + "" + ch[i]);
				cnt = 1;
			}
		}
		return s.toString();
	}
}
