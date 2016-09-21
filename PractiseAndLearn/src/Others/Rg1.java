package Others;

public class Rg1 {

	public static void main(String args[]) {
		m1();
	}

	private static void m1() {
		int max = 0, maxi = 0;
		for (int i = 1000000; i > 0; i--) {
			if (i % 2 == 0)
				continue;
			int cnt = findTimes(i);
			if (cnt > max) {
				max = cnt;
				maxi = i;
			}

		}
		System.out.println(maxi + ":" + max);
	}

	private static int findTimes(int j) {
		int cnt = 0;
		while (j >1) {
			cnt++;
			if (j % 2 == 1)
				j = (3 * j + 1);
			else
				j = (j / 2);
		}
		return cnt;
	}

}
