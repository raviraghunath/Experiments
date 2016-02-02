package Arrays;


public class FindCommonElementsInNSortedArrays {

	public static void main(String[] args) {
		int[][] arrays = { { 23, 34, 67, 89, 123, 566, 1000 },
				{ 11, 22, 23, 24, 33, 37, 185, 566, 987, 1223, 1234 },
				{ 23, 43, 67, 98, 566, 678 },
				{ 1, 4, 5, 23, 34, 76, 87, 132, 566, 665 },
				{ 1, 2, 3, 23, 24, 344, 566 } };
		method1(arrays);
	}

	private static void method1(int[][] arrays) {
		if (arrays == null || arrays.length < 2) {
			return;
		}
		int thresold[] = new int[arrays.length];
		for (int i = 0, n = arrays[0].length; i < n; i++) {
			int ele = arrays[0][i];
			boolean foundMatch = false;
			for (int j = 1, m = arrays.length; j < m; j++) {
				int k=thresold[j];
				for (int p = arrays[j].length; k < p; k++) {
					if (ele == arrays[j][k]) {
						thresold[j]=k;
						foundMatch = true;
						break;
					}
					if(ele<arrays[j][k]){break;}
				}
				if (!foundMatch)
					break;
			}
			if (foundMatch)
				System.out.print(ele+",");
		}
	}
}
