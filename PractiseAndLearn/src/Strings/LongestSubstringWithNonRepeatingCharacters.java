package Strings;

public class LongestSubstringWithNonRepeatingCharacters {

	public static void main(String[] args) {
		method1("ABCDABDABCDEFGHIEFGCABD");

	}
	
	private static void method1(String s){
		char [] cArray = s.toCharArray();
		int [] consTray = new int[256];
		initializeArray(consTray, 0);
		int maxSize = 0,maxSt=0,maxEd=0,currSize=0,currSt=0;
		for(int i=0,n=cArray.length;i<n;i++){
			if(consTray[cArray[i]]==0){
				currSize++;
				consTray[cArray[i]]++;
			}else{
				if(currSize>maxSize){
					maxSize= currSize;
					maxEd=i-1;
					maxSt=currSt;
				}
				currSize=0;
				currSt=i;
				initializeArray(consTray, 0);
				i--;//Again coming back to this element
			}
		}
		System.out.println(s.substring(maxSt, maxEd+1));
	}

	private static void initializeArray(int [] array, int iniEle){
		for(int i=0,n=array.length;i<n;i++){
			array[i]=iniEle;
		}
	}
}
