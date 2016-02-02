package Arrays;


public class PancakeSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] arr =new int[]{4,1,2,5,3}; 
		flipSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		
	}
	
	private static int findMaxPosition(int[]arr, int st, int ed){
		int max=st;
		for(int i=st;i<=ed;i++)if(arr[i]>arr[max])max=i;
		return max;
	}
	private static void flipArray(int [] arr,int st,int ed){
		while(st<ed){
			int t=arr[st];
			arr[st]=arr[ed];
			arr[ed]=t;
			st++;ed--;
		}
	}
	private static void flipSort(int arr[]){
		for(int i=arr.length-1;i>=0;i--){
			int max = findMaxPosition(arr, 0, i);
			flipArray(arr, 0, max);
			flipArray(arr, 0, i);
		}
	}

}
