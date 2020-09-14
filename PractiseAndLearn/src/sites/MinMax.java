package sites;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/mini-max-sum/problem
public class MinMax {

	public static void main(String[] args) {
		method1(new int[] {256741038, 623958417, 467905213, 714532089, 938071625}, 4);
	}
	
	
	private static void method1(int[] arr, int n) {
		Arrays.sort(arr);
		int mxSt = arr.length - n;
		long min =0 ,  max =0;
		
		for(int i=0;i<arr.length;i++) {
			if(i<n) {
				min += arr[i];
			}
			if( mxSt<= i ) {
				max += arr[i];
			}
		}
		System.out.println(min+" "+max);
	}
	
}
