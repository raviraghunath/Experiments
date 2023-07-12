package Experiment;

public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		int n = 8;
		System.out.println(fibonacci.fib1(8));
		System.out.println(fibonacci.fib(8));
	}

	public int fib1(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int i1 = 0;
		int i2 = 1;
		for (int i = 0; i <= n - 2; i++) {
			int t = i1 + i2;
			i1 = i2;
			i2 = t;
		}
		return i2;
	}

	public int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

}
