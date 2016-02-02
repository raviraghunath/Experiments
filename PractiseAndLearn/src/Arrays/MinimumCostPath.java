package Arrays;

public class MinimumCostPath {

	public static void main(String[] args) {
		int[][] array = { { 3, 2, 8 }, { 1, 9, 7 }, { 0, 5, 2 }, {6, 4, 3} };
		int[][] valArray = new int [4][3];
		System.out.println(method1(array, 0, 0, 0));
		System.out.println("@@@@@@@@");
		valArray[0][0]=array[0][0];
		method2(array, valArray, 0, 1);
		for(int i=0,n=valArray.length;i<n;i++){
			for(int j=0,m=valArray[0].length;j<m;j++){
				method2(array, valArray, i, j);
			}
		}
		for(int i=0,n=valArray.length;i<n;i++){
			for(int j=0,m=valArray[0].length;j<m;j++){
				System.out.print(valArray[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("@@@@@@@@");
		System.out.println(valArray[valArray.length-1][valArray[0].length-1]);
	}

	private static int method1(int [][] array,int iIn, int jIn, int tot){
		if(iIn==array.length&&jIn==array[0].length){return tot;}
		if(iIn==array.length||jIn==array[0].length){return Integer.MAX_VALUE;}
		int val1 = method1(array, iIn+0, jIn+1, tot+array[iIn][jIn]);
		int val2 = method1(array, iIn+1, jIn+0, tot+array[iIn][jIn]);
		int val3 = method1(array, iIn+1, jIn+1, tot+array[iIn][jIn]);
		return min(val1, val2, val3);
	}
	
	private static int min(int i, int j,int k){
		if(i<j){
			return (i<k)?i:k;
		}else{
			return (j<k)?j:k;
		}
	}
	
	private static void method2(int[][]array,int[][]valArr,int iIn, int jIn){
		if(iIn==array.length||jIn==array[0].length){return ;}
		int val1 = Integer.MAX_VALUE;if(iIn-1>=0&&jIn-1>=0)val1=valArr[iIn-1][jIn-1];
		int val2 = Integer.MAX_VALUE;if(jIn-1!=-1)val2=valArr[iIn][jIn-1];
		int val3 = Integer.MAX_VALUE;if(iIn-1!=-1)val3=valArr[iIn-1][jIn];
		int min = min(val1,val2,val3);
		if(min==Integer.MAX_VALUE)min=0;
		valArr[iIn][jIn]=array[iIn][jIn] + min;
//		System.out.println(iIn+","+jIn+","+valArr[iIn][jIn]);
	}
}
