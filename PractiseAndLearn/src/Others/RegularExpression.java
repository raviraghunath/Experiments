package Experiment;

public class RegularExpression {
	public static void main(String[] args) {
		RegularExpression regularExpression = new RegularExpression();
		System.out.println(regularExpression.isMatch("a", ".*.."));
	}

	public boolean isMatch(String s, String p) {
		return isMatch(s, p, 0, 0);
	}

	public boolean isMatch(String s, String p, int i, int j) {
		if (i == s.length()
				&& (j == p.length() || (j == p.length() - 2 && (p.charAt(j + 1) == '*' )))) {
			return true;
		}
		if (j == p.length() || i == s.length()) {
			return false;
		}
		if (p.charAt(j) == '.') {
			if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
				return isMatch(s, p, i, j + 2) || isMatch(s, p, i + 1, j) || isMatch(s, p, i + 1, j + 2);
			} else {
				return isMatch(s, p, i + 1, j + 1) ;
			}
		} else if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
			boolean b = s.charAt(i) == p.charAt(j);
			if (b) {
				b = isMatch(s, p, i + 1, j) || isMatch(s, p, i + 1, j + 2);
			}
			return isMatch(s, p, i, j + 2) || b;
		} else if (s.charAt(i) == p.charAt(j)) {
			return isMatch(s, p, i + 1, j + 1);
		} else {
			return false;
		}

	}

//	public boolean isMatch1(String s, String p, int i, int j) {
//		if (i == s.length()
//				&& (j == p.length() || (j == p.length() - 2 && (p.charAt(j + 1) == '*' || p.charAt(j + 1) == '.')))) {
//			return true;
//		}
//		if (j == p.length()) {
//			return false;
//		}
//
//		if (j < p.length() - 1 && (p.charAt(j + 1) == '*' || p.charAt(j + 1) == '.')) {
//			if (p.charAt(j + 1) == '*') {
//				if (p.charAt(j) == '.') {
//					return isMatch1(s, p, i + 1, j) || isMatch1(s, p, i, j + 2) || isMatch1(s, p, i + 1, j + 2);
//				}
//				boolean b = s.charAt(i) == p.charAt(j);
//				if (b) {
//					b = isMatch1(s, p, i + 1, j) || isMatch1(s, p, i + 1, j + 2);
//				}
//				return isMatch1(s, p, i, j + 2) || b;
//			} else if (p.charAt(j + 1) == '.') {
//				boolean b = s.charAt(i) == p.charAt(j);
//				if (b) {
//					b = isMatch1(s, p, i + 1, j + 2);
//				}
//				return isMatch1(s, p, i, j + 2) || b;
//			}
//		} else {
//			if (s.charAt(i) == p.charAt(j)) {
//				return isMatch1(s, p, i + 1, j + 1);
//			} else {
//				return false;
//			}
//		}
//		return false;
//	}
}
