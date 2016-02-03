/**
 * 
 */
package Strings;

import java.util.HashSet;
import java.util.Stack;
/*Url : http://www.ideserve.co.in/learn/postfix-expression-evaluation*/
public class PostfixExpressionEvaluation {

	static HashSet<String> symbols = new HashSet<String>(4);
	static{
		symbols.add("+");symbols.add("-");symbols.add("*");symbols.add("/");
	}
	public static void main(String[] args) {
		String [] str = {"5","1","2","+","4","*","+","3","-"};
		method1(str);
	}

	private static void method1(String[] s){
		Stack<String>stack= new Stack<String>();
		for(int i=0,n=s.length;i<n;i++){
			if(symbols.contains(s[i])&&stack.size()>=2){
				String c2 = stack.pop();
				String c1 = stack.pop();
				int val = doCalc(c1,c2,s[i]);
				stack.push(String.valueOf(val));
			}else{
				stack.push(s[i]);
			}
		}
		if(stack.size()==1)System.out.println(stack.peek());
		else System.out.println("Invalid String");
	}
	
	private static int doCalc(String c1, String c2, String sym){
		int i1 = Integer.parseInt(c1);
		int i2 = Integer.parseInt(c2);
		if(("+").equals(sym)){
			return i1+i2;
		}else if(("-").equals(sym)){
			return i1-i2;
		}else if(("*").equals(sym)){
			return i1*i2;
		}else{
			return i1/i2;
		}
	}
}
