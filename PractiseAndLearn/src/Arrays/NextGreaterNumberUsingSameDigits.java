package Arrays;

import java.util.Arrays;

public class NextGreaterNumberUsingSameDigits {
	public static void main(String[] args) {
		int []array ={6,9,3,8,6,5,2};
		method1(array);
	}
	
	private static void method1(int [] array){
		int ele1 = increasingPatternBreakPosition(array);
		int ele2 = findPositionOfHigherNumInRev(array, ele1);
		int t = array[ele2];
		array[ele2]=array[ele1];
		array[ele1]=t;
		sortPartArray(array, ele1+1);
		for(int i=0,n=array.length;i<n;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	private static void sortPartArray(int array[],int index){
		Arrays.sort(array, index, array.length);
	}
	
	private static int findPositionOfHigherNumInRev(int array[], int index){
		int ele = array[index];
		for(int i=array.length-1;i>index;i--){
			if(array[i]>ele){
				return i;
			}
		}
		return -1;
	}
	
	private static int increasingPatternBreakPosition(int [] array){
		for(int i=array.length-1;i>=0;i--){
			if(i==0)break;
			if(array[i]>array[i-1]){return i-1;}
		}
		return -1;
	}
}
