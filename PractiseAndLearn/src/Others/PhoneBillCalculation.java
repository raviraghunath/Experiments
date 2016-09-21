package Others;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

/*Each call is billed separately. The billing rules are as follows:

If the call was shorter than 5 minutes, then you pay 3 cents for every started second of the call (e.g. for duration "00:01:07" you pay 67 * 3 = 201 cents).
If the call was at least 5 minutes long, then you pay 150 cents for every started minute of the call (e.g. for duration "00:05:00" you pay 5 * 150 = 750 cents and for duration "00:05:01" you pay 6 * 150 = 900 cents).
All calls to the phone number that has the longest total duration of calls are free. In the case of a tie, if more than one phone number shares the longest total duration, the promotion is applied only to the phone number whose numerical value is the smallest among these phone numbers.
*/
public class PhoneBillCalculation {

	public static void main(String args[]) {
		String s = "00:01:07,400-234-090and00:05:01,701-080-080and00:05:00,400-234-090and00:05:00,500-234-090and00:01:07,500-234-090";
		HashMap<String, Long> map = getMap(s);
		TreeMap<String, Long> tMap = new TreeMap<>(new comp(map));
		tMap.putAll(map);
		int i = 0;
		int tot = 0;
		for (Entry<String, Long> entry : tMap.entrySet()) {
			if (i == 0) {
				i++;
				continue;
			}
			if (entry.getValue() < 300) {
				tot += entry.getValue() * 3;
			} else {
				tot += (entry.getValue() / 60) * 150;
				tot += (entry.getValue() % 60 == 0 ? 0 : 1) * 150;
			}
		}
		System.out.println(tot);
	}

	static class comp implements Comparator<String> {
		HashMap<String, Long> map;

		comp(HashMap<String, Long> map) {
			this.map = map;
		}

		@Override
		public int compare(String o1, String o2) {
			if (map.get(o1) < map.get(o2)) {
				return 1;
			} else if (map.get(o1) > map.get(o2)) {
				return -1;
			} else {
				int i = getSumPhNo(o1);
				int j = getSumPhNo(o2);
				if (i > j)
					return -1;
				else
					return 1;
			}
		}

	}

	private static Integer getSumPhNo(String s) {
		char[] ch = s.toCharArray();
		return (int) ch[0] + (int) ch[1] + (int) ch[2] + (int) ch[4] + (int) ch[5] + (int) ch[6] + (int) ch[7]
				+ (int) ch[8] + (int) ch[9];
	}

	private static int m1(TreeMap<String, Long> map) {

		return 0;
	}

	private static HashMap<String, Long> getMap(String s) {
		HashMap<String, Long> map = new HashMap<String, Long>();
		for (String str : s.split("and")) {
			String string[] = str.split(",");
			long dur = 0;
			int i = 0;
			for (String str1 : string[0].split(":")) {
				if (i == 0) {
					dur += Integer.parseInt(str1) * 3600;
				} else if (i == 1) {
					dur += Integer.parseInt(str1) * 60;
				} else {
					dur += Integer.parseInt(str1);
				}
				i++;
			}
			if (map.containsKey(string[1])) {
				map.put(string[1], map.get(string[1]) + dur);
			} else {
				map.put(string[1], dur);
			}
		}
		return map;
	}

}
