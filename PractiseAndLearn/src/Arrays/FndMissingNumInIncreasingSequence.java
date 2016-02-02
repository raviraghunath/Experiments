package Arrays;

public class FndMissingNumInIncreasingSequence {

	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6,7,8,9};
		System.out.println(method1(array, 0, (array.length-1)));
	}
	
	private static int method1(int [] array,int st,int ed){
		if(st==ed){return (array[st]!=st+1)?st+1:0;}
		int index = st+((ed-st+1)/2)-1;
		if(array[index]==(index+1)){
			return method1(array, index+1, ed);
		}else{
			return method1(array, st, index);
		}
	}

}
