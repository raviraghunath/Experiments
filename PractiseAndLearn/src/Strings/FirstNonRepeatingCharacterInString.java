package Strings;

public class FirstNonRepeatingCharacterInString {

	public static void main(String[] args) {
		method1("ABCDEFGHIJKLADTVDERFSWVGHQWCNOAPIENSMSJIWIERTFBI",0);
	}
	
	private static void method1(String s,int howManyRepest){
		int [] consTray = new int[256]; //256 characters in UniCode (32 bytes)
		initializeArray(consTray, -1);
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(consTray[c]==0)
				consTray[c]=i;
			else
				consTray[c]=consTray[c]+1000;
		}
		int min =Integer.MAX_VALUE;int cha = -1;

		for(int i=0;i<consTray.length;i++){
			if(consTray[i]>=(howManyRepest*1000) && consTray[i]<min){
				min = consTray[i];cha = i;
			}
		}
		System.out.println((char)cha);
	}
	private static void initializeArray(int [] array, int iniEle){
		for(int i=0,n=array.length;i<n;i++){
			array[i]=iniEle;
		}
	}


}
