package Strings;

import java.util.Stack;

public class CheckBalancedParenthesesInString {

	public static void main(String[] args) {
		String str = "((BCD)AE)";
		System.out.println(method1(str));
	}

	private static boolean method1(String str) {
		if (str.charAt(0) == ')' || str.charAt(str.length() - 1) == '(') {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0, n = str.length(); i < n; i++) {
			char ch = str.charAt(i);
			if (ch == ')') {
				boolean b = removeEleTillFirstOpenBracket(stack);
				if (b == false)
					return false;
			} else {
				stack.push(ch);
			}
		}
		return stack.size() == 0;
	}

	private static boolean removeEleTillFirstOpenBracket(Stack<Character> stack) {
		while (!stack.isEmpty()) {
			char c = stack.pop();
			if (c == '(') {
				return true;
			}
		}
		//still not found '('
		return false;
	}
}
