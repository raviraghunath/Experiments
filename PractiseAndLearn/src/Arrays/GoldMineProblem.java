package Arrays;

import java.util.Collections;

public class GoldMineProblem {

	public static void main(String[] args) {
		int [][] array =  { { 1, 3, 1, 5 }, 
				{ 2, 2, 4, 1 }, 
				{ 5, 0, 2, 1 },
				{ 0, 6, 1, 2 } };

		System.out.println(method1(array, 2, 0, 0));

	}

	private static int method1(int array[][], int iIn, int jIn, int tot) {
		if(jIn==array[0].length){return tot;}
		tot += array[iIn][jIn];
		int val1 = 0;
		if(iIn>0)
			val1 = method1(array, iIn - 1, jIn + 1, tot);
		int val2 = method1(array, iIn, jIn + 1, tot);
		int val3 = 0;
		if(iIn<array.length-1)
			val3 = method1(array, iIn + 1, jIn + 1, tot);
		return max(val1, val2, val3);
	}

	private static int max(int val1, int val2, int val3) {
		if (val1 > val2) {
			if (val1 > val3) {
				return val1;
			} else
				return val3;
		} else {
			if (val2 > val3) {
				return val2;
			} else
				return val3;
		}
	}

}
