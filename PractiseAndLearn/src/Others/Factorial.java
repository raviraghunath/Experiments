package Others;

public class Factorial {

	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.fact(5));
		System.out.println(factorial.fact1(5));
	}

	int fact(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return n * fact(n - 1);
	}

	int fact1(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
}
