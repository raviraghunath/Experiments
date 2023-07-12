package Experiment;

public class Hanoi {

	public void toh(int N, int from, int to, int aux) {
		if (N == 0 || N == 1) {
			return;
		}
		toh(N - 1, from, aux, to);
		System.out.println("");
		toh(N - 1, aux, to, from);
	}
}
