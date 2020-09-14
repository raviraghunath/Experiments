package sites;

//https://www.hackerrank.com/challenges/birthday-cake-candles/problem?h_r=next-challenge&h_v=zen
public class birthdaycakecandles {

	public static void main(String[] args) {
		method1(new int[] {3,2,1,3});
	}

	private static void method1(int[] arr) {
		int max = -1, maxCnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxCnt=1;
			} else if (arr[i] == max) {
				maxCnt++;
			}
		}
		System.out.println(maxCnt);
	}

}
