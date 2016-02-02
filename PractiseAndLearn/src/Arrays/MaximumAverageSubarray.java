package Arrays;

public class MaximumAverageSubarray {

	public static void main(String[] args) {
		findMaxAvgSubArr(new int[]{11,-8,16,-7,24,-2,3}, 7);
	}
	
	private static void findMaxAvgSubArr(int[]array,int k){
		if(array==null||array.length==0||array.length<k){return;}
		int maxSum=0,sum=0,maxStartPos=0;
		int start=array[0];
		for(int i=0;i<k;i++){
			sum+=array[i];
		}
		maxSum=sum;
		for(int i=k,n=array.length;i<n;i++){
			sum-=start;sum+=array[i];start=array[i-(k-1)];
			if(sum>maxSum){maxSum=sum;maxStartPos=i-(k-1);}
		}
		System.out.println(maxSum);
		System.out.println(maxStartPos);
		for(int i=maxStartPos;i<maxStartPos+k;i++){
			System.out.print(array[i]+" ");
		}
	}

}
