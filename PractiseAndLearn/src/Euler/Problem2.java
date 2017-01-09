package Euler;

import java.math.BigInteger;

public class Problem2 {

	public static void main(String[] args) {
		m1(new BigInteger("4000000"));
	}

	private static void m1(BigInteger limit) {
		BigInteger two = new BigInteger("2");
		
		BigInteger i = new BigInteger("1");
		BigInteger j = new BigInteger("2");
		BigInteger count = new BigInteger("3");
		BigInteger evenSum = new BigInteger("2");
		while (count.compareTo(limit) == -1 || count.compareTo(limit) == 0) {
			BigInteger t = i.add(new BigInteger(String.valueOf(j)));
			i = j;
			j = t;
			count =  count.add(BigInteger.ONE);
			if (t.remainder(two) == BigInteger.ZERO)
				evenSum = evenSum.add(new BigInteger(String.valueOf(t)));
		}
		System.out.println("\n" + evenSum);
	}

}
