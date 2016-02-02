package Arrays;

public class IntegerArrayCorrespondingToIncreaseDecreaseSequence {

	public static void main(String[] args) {
		String str = "ddddi";
		int [] ar = method1(str);
		for(int i=0,n=ar.length;i<n;i++){
			System.out.print(ar[i]+" ");
		}
	}
	private static int[] method1(String str){
		int len = str.length();
		int [] ar = new int[len+1];
		int iOcc=0;
		for(int i=0;i<len;i++){
			if(str.charAt(i)=='i')iOcc++;
		}
		int dSt=(len+1)-iOcc;
		int iSt = dSt+1;
		ar[0]=(str.charAt(0)=='d')?dSt--:iSt++;
		for(int i=0;i<len;i++){
			ar[i+1]=(str.charAt(i)=='d')?dSt--:iSt++;
		}
		return ar;
	}

}
