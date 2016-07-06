package Arrays;

public class PublicTransportTticketsProb1 {

	public static void main(String[] args) {
		PublicTransportTticketsProb1 r1 = new PublicTransportTticketsProb1();
		int A[] = new int[] { 22, 23, 24, 28, 29, 30, 31, 32 };
		System.out.println(r1.solution(A));
	}

	public int solution(int[] A) {
		int len = A.length;
		if (len >= 25)
			return 25;
		if (A.length == 0)
			return 0;
		int B[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int currArrayVal = A[i];
			int j = i + 1;
			int currVal = 1;
			while (j < B.length && A[j] <= currArrayVal + 6) {
				currVal++;
				j++;
			}
			B[i] = currVal;
		}
		int maxIndex = findMaxIndex(B);
		int sum = 0;
		int cnt = 1;
		for (int i = maxIndex + 1; i < A.length && i <= maxIndex + 6; i++) {
			if (A[i] <= A[maxIndex] + 6) {
				A[i] = 0;
				cnt++;
			}
		}
		A[maxIndex] = 0;
		sum = cnt >= 4 ? 7 : cnt * 2;
		return sum + solution(eradicateZero(A));
	}

	private int[] eradicateZero(int a[]) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				cnt++;
		}
		int[] b = new int[a.length - cnt];
		for (int i = 0, j = 0; i < a.length; i++) {
			if (a[i] != 0) {
				b[j] = a[i];
				j++;
			}
		}
		return b;
	}

	private int findMaxIndex(int a[]) {
		int max = 0;
		int maxVal = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maxVal) {
				maxVal = a[i];
				max = i;
			}
		}
		return max;
	}

	private void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}
}