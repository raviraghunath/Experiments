package Arrays;

import java.util.Arrays;

public class LengthLongestSubArrayWithElementsContiguousSequence {

	public static void main(String[] args) {
		int array[]={10,12,11,94,56,32,34,36,33,35,37,8,7,9,5,4,6};
		int length = method1(array);
		System.out.println(length);
	}
	
	private static int method1(int [] array){
		if(array==null||array.length==0){
			return 0;
		}
		Arrays.sort(array);
		int length =1;
		int len =1;
		for(int i=0,n=array.length;i<n-1;i++){
			if(array[i+1]-array[i]==1){
				len++;
			}else{
				len=1;
			}
			if(len>length)length=len;
		}
		return length;
	}

}
