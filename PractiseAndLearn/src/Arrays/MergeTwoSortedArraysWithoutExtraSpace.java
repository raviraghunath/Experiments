package Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

	public static void main(String[] args) {
		int [] array = {1,-1,3,-1,6,-1,9,11,12};
		int [] array2 = {2,4,5,8};
		method1(array);
		method2(array, array2);
		for(int i=0,n=array.length;i<n;i++)System.out.print(array[i]+" ");
	}
	
	private static void method2(int[]arr1,int[] arr2){
		method1(arr1);
		int arr1Pointer = nextInvalidNumPos(arr1, arr1.length-1)+1,arr2Pointer = 0;
		for(int i=0;arr2Pointer<arr2.length;i++){
			if(arr1[arr1Pointer]>arr2[arr2Pointer]){
				arr1[i]=arr2[arr2Pointer];
				arr2Pointer++;
			}else{
				arr1[i]=arr1[arr1Pointer];
				arr1Pointer++;
			}
		}
		
		
	}
	
	private static void method1(int []arr1){			
		int elePointer=nextInvalidNumPos(arr1, arr1.length-1);
		for(int i=arr1.length-1;i>=0;i--){
			if(arr1[i]!=-1 && elePointer>i){
				arr1[elePointer]=arr1[i];
				arr1[i]=-1;
				elePointer=nextInvalidNumPos(arr1, i+1);
			}
		}
	}
	
	private static int nextInvalidNumPos(int [] array,int position){
		for(int i=position;i>=0;i--){
			if(array[i]==-1)return i;
		}
		return -1;
	}

}
