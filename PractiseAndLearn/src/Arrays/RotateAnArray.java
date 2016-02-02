package Arrays;
/*http://www.ideserve.co.in/learn/rotate-an-array*/
public class RotateAnArray {

	public static void main(String[] args) {
		int [] array = {1,2,3,4,5};
		int [] array1=method1(array, 3);
		for (int i = 0, n = array1.length; i < n ; i++) {
			System.out.print(array1[i]+" ");
		}
		System.out.println();
		method2(array, 3);
		for (int i = 0, n = array.length; i < n ; i++) {
			System.out.print(array[i]+" ");
		}
		
	}
	
	private static int[] method1(int array[],int k){
		int len = array.length;
		int array1[]=new int[len];
		for (int i = 0, n = array.length; i < n ; i++) {
			int pos=-1;
			if(i+k>=len){
				pos = Math.abs(len-(i+k));
			}else{
				pos=i+k;
			}
			array1[i]=array[pos];
		}
		return array1;
	}
	
	private static void reverseArray(int [] array,int st, int ed){
		
		int i=st,j=ed;
		
		while(i<j){
			int t= array[i];
			array[i]=array[j];
			array[j]=t;
			i++;j--;
		}
		
	}
	//Efficient
	private static void method2(int [] array,int k){
		reverseArray(array, 0, k-1);
		reverseArray(array, k, array.length-1);
		reverseArray(array, 0, array.length-1);
	}

}
