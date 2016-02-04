package Strings;

public class ReverseWordsInString {

	public static void main(String[] args) {
		method1("This is a string");
	}

	private static void method1(String str) {
		char [] cArray = str.toCharArray();
		int i=0,j=cArray.length-1;
		while(i<j){
			char t = cArray[i];
			cArray[i]=cArray[j];
			cArray[j]=t;
			i++;
			j--;
		}
		System.out.println(new String(cArray));
	}
}
