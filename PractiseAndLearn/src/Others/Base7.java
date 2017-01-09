package Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(convert(Integer.parseInt(br.readLine())));
		} catch (NumberFormatException | IOException e) {
		}
	}

	static String convert(int num) {
		StringBuilder res = new StringBuilder("");
		int rem;
		while (num > 0) {
			rem = num % 7;
			switch (rem) {
			case 0:
				res.append("0");
				break;
			case 1:
				res.append("a");
				break;
			case 2:
				res.append("t");
				break;
			case 3:
				res.append("l");
				break;
			case 4:
				res.append("s");
				break;
			case 5:
				res.append("i");
				break;
			case 6:
				res.append("n");
				break;
			default:
				res.append(rem);
				break;
			}
			num /= 7;
		}
		return res.toString();
	}

}
