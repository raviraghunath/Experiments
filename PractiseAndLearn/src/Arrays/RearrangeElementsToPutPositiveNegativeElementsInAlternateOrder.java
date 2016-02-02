package Arrays;

public class RearrangeElementsToPutPositiveNegativeElementsInAlternateOrder {

	public static void main(String[] args) {
		int [] arr = {1,-2,-7,-8,9,-10};
		for(int i=0,n=arr.length;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		method1(arr);
		System.out.println();
		for(int i=0,n=arr.length;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	private static void method1(int [] array){
		if(array==null||array.length==0)return;
		int pCount =0,nCount=0;
		for(int i=0,n=array.length;i<n;i++){
			if(array[i]>=0)pCount++;else nCount++;
		}
		int count = (pCount>=nCount)?nCount*2:pCount*2;
		for(int i=0,n=count;i<n;i++){
			if(i%2!=0){//odd
				if(array[i]>=0){//Positive
					int ind=findNextSign(array, i+1, sign.Negative);
					shiftLeft(array, i, ind);
				}else{//Negative
				}
			}else{//even
				if(array[i]>=0){//Positive
					
				}else{//Negative
					int ind=findNextSign(array, i+1, sign.Postive);
					shiftLeft(array, i, ind);
				}
			}
		}
	}
	
	private static void shiftLeft(int [] array,int st,int ed){
		if(array==null||array.length==0)return;
		int t=array[st];
		for(int i=st;i<=ed;i++){
			if(i==ed){
				array[st]=t;
			}else{
				int t1=array[i+1];
				array[i+1]=t;
				t=t1;
			}
		}
	}

	private static int findNextSign(int [] array, int stIndex, sign sign){
		for(int i=stIndex,n=array.length;i<n;i++){
			if(sign==sign.Postive){
				if(array[i]>=0){
					return i;
				}
			}else{
				if(array[i]<0){
					return i;
				}
			}
		}
		return -1;
	}
	static enum sign{
		Postive,Negative;
	}
}
