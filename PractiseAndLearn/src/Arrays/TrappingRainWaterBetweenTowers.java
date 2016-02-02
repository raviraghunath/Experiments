package Arrays;

public class TrappingRainWaterBetweenTowers {

	public static void main(String[] args) {
		int array[] = { 1, 5, 2, 3, 1, 7, 2, 4 };
		System.out.println(method1(array));
	}

	private static int method1(int array[]) {
		int tot = 0;
		for (int i = 0, n = array.length; i < n - 1; i++) {
			tot += Math.min(array[i],array[i + 1]);
		}
		return tot;
	}

}
