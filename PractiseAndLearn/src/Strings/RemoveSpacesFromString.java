package Strings;

/*URL :http://www.ideserve.co.in/learn/remove-spaces-from-string*/
public class RemoveSpacesFromString {

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("  Hi,How are you da dai?");
		System.out.println("B4 : " + s);
		method1(s);
		System.out.println("After : " + s);
	}

	private static void method1(StringBuilder s) {
		int sp = -1;
		for (int i = 0, n = s.length(); i < n; i++) {
			if (s.charAt(i) != ' ') {
				if (sp != -1) {
					s.replace(sp, sp + 1, String.valueOf(s.charAt(i)));
					s.replace(i, i + 1, " ");
					/*if(i pointer is just after sp then sp = i otherwise there would be more than spaces so sp++;)*/
					if(sp==(i-1))sp=i;else sp++;
				}
			} else {
				if (sp == -1)
					sp = i;
			}
		}
	}

	
	private static int findNxtSpaceIndex(StringBuilder s,int st){
		for (int i = st, n = s.length(); i < n; i++) {
			if(s.charAt(i)==' '){
				return i;
			}
		}
		return -1;
	}
}
