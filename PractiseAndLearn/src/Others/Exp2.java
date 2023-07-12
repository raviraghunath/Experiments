package Experiment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exp2 {

	public static void main(String[] args) {
		String s = "MCMXCIV";
		Exp2 exp2 = new Exp2();
		System.out.println(exp2.romanToInt(s));
		System.out.println(exp2.romanToInt1(s));
	}

	private enum Symbol {
		V(5, null), L(50, null), D(500, null), M(1000, null), C(100, new HashSet<>(Arrays.asList(D, M))),
		X(10, new HashSet<>(Arrays.asList(L, C))), I(1, new HashSet<>(Arrays.asList(V, X)));

		int value;
		Set<Symbol> depSymbols;

		Symbol(int value, Set<Symbol> depSymbols) {
			this.value = value;
			this.depSymbols = depSymbols;
		}

		int getValue() {
			return value;
		}

		Set<Symbol> getDepSymbols() {
			return depSymbols;
		}

		static Symbol getSymbol1(String s) {
			return Symbol.valueOf(Symbol.class, s);
		}
	}

	public int romanToInt1(String s) {
		int value = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Symbol symbol1 = Symbol.getSymbol1(String.valueOf(c));

			if (i < s.length() - 1) {
				char c1 = s.charAt(i + 1);
				Symbol symbol2 = Symbol.getSymbol1(String.valueOf(c1));
				if (null != symbol1.getDepSymbols() && symbol1.getDepSymbols().contains(symbol2)) {
					value += (symbol2.getValue() - symbol1.getValue());
					i++;
					continue;
				}
			}
			value += symbol1.getValue();

		}
		return value;
	}

	public int romanToInt(String s) {
		int value = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Symbol symbol1 = Symbol.getSymbol1(String.valueOf(c));
			if (i < s.length() - 1) {
				if (symbol1 == Symbol.I) {
					char c1 = s.charAt(i + 1);
					Symbol symbol2 = Symbol.getSymbol1(String.valueOf(c1));
					if (symbol2 == Symbol.V) {
						value += 4;
						i++;
						continue;
					} else if (symbol2 == Symbol.X) {
						value += 9;
						i++;
						continue;
					}
				} else if (symbol1 == Symbol.X) {
					char c1 = s.charAt(i + 1);
					Symbol symbol2 = Symbol.getSymbol1(String.valueOf(c1));
					if (symbol2 == Symbol.L) {
						value += 40;
						i++;
						continue;
					} else if (symbol2 == Symbol.C) {
						value += 90;
						i++;
						continue;
					}
				} else if (symbol1 == Symbol.C) {
					char c1 = s.charAt(i + 1);
					Symbol symbol2 = Symbol.getSymbol1(String.valueOf(c1));
					if (symbol2 == Symbol.D) {
						value += 400;
						i++;
						continue;
					} else if (symbol2 == Symbol.M) {
						value += 900;
						i++;
						continue;
					}
				}
			}
			value += symbol1.getValue();
		}
		return value;
	}
}
