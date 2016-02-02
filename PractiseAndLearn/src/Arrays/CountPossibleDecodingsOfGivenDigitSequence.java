package Arrays;

import java.util.HashSet;

public class CountPossibleDecodingsOfGivenDigitSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<String> list = disMantle(1234, 3);
		for (String str : list) {
			System.out.print(str + "   ");
		}
		System.out.println();
		int[] arr = { 1, 2, 3, 4 };
		list = disMantle(arr);
		for (String str : list) {
			System.out.print(str + "   ");
		}
	}

	private static HashSet<String> disMantle(int num, int power) {
		HashSet<String> list = new HashSet<String>();
		int divident = (int) Math.pow(10, power);
		int q = num / divident;
		if (q > 27) {
			return list;
		}
		int rem = num % divident;
		if (rem > 0 && rem < 27 && q < 27)
			list.add(q + "," + rem);
		else if (rem == 0 && q < 27)
			list.add("" + q);
		{
			if (power > 0) {
				HashSet<String> subList = disMantle(rem, power - 1);
				for (String str : subList) {
					list.add(q + "," + str);
				}
			}
		}
		int pow = power;
		while (pow > 0) {
			HashSet<String> subList = disMantle(num, --pow);
			list.addAll(subList);
		}
		return list;
	}

	private static HashSet<String> disMantle(int num[]) {
		HashSet<String> list = new HashSet<String>();
		for (int i = 0, n = num.length; i < n; i++) {
			String str = "";
			int li=0;
			while(li<i){
				str+=num[li]+",";li++;
			}
			int sum = num[i];
			int j = i + 1;
			while (true) {
				if (j < n) {
					sum = sum * 10 + num[j];
					if (sum < 27) {
						str += sum;
					} else {
						sum = (sum-num[j])/10;
						str += ","+num[j]+",";
						sum=0;
					}
				} else if (sum == n - 1) {
					str += num[i];
				} else {
					str += ",";
					break;
				}
				j++;
			}
			if(str.length()>1)
			list.add(str);
		}
		return list;
	}

}
