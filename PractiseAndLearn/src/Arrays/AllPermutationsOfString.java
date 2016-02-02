package Arrays;

import java.util.HashSet;

public class AllPermutationsOfString {

	public static void main(String[] args) {
		System.out.println(getDifferentInsertedStrings("a", "bc"));
		System.out.println(getDifferentInsertedStrings("ab", "c"));
	}
	
	
	private static HashSet<String> getPermutations(String s,int pos){
		HashSet<String> hashSet=new HashSet<String>();
		if(pos==s.length()){return hashSet;}
		String str1 = s.substring(0,pos);
		String str2 = s.substring(pos);
		hashSet.addAll(getDifferentInsertedStrings(str1, str2));
		hashSet.addAll(getPermutations(s, ++pos));
		return hashSet;
	}
	
	private static HashSet<String> getDifferentInsertedStrings(String s1,String s2){
		System.out.println(s1+","+s2);
		HashSet<String> hashSet=new HashSet<String>();
		char[] charArray = s2.toCharArray();
		hashSet.add(s1+s2);
		for(int i=0,n=charArray.length;i<n;i++){
			String s=s2.substring(0,i+1)+s1+s2.substring(i+1);
			hashSet.add(s);
		}
		return hashSet;
	}

}
