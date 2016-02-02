package Arrays;

public class SetPartitionProblemRecursion {

	public static void main(String[] args) {
		int array[]={21,33,37,1};
		int sum=0;
		for(int i=0,n=array.length;i<n;i++){
			sum+=array[i];
		}
		if(sum%2!=0){System.out.println("Can not be sepearted");}
		else{
			sum = sum/2;
			System.out.println(method1(array, 0, sum));
		}
	}
	
	private static boolean method1(int [] array,int index,int tot){
		if(index==array.length){return false;}
		int ele = array[index];
		if(tot-ele==0){return true;}
		index++;
		if(tot-ele>0){
			boolean b= method1(array, index, tot-ele);
			if(b==true){return true;}
		}
		return method1(array, index, tot);
	}
	
}
