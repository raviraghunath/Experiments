package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//[rockstar, rock, star, rocks, tar, super,   highway, high, way, superhighway]
//
//rockstar -> rock + star
//         -> rocks + tar 
//rock -> 
//star ->
//rocks ->
//tar ->
//super ->
//highway -> high + way 
//high -> 
//way ->
//superhighway -> super + highway
//             -> super + high + way 
//             
public class AmazonCheckStringOccurences {

	Map<String, List<String>> cache = new HashMap<>();

	public static void main(String[] args) {

		AmazonCheckStringOccurences amazonCheckStringOccurences = new AmazonCheckStringOccurences();

		Map<String, List<String>> res = amazonCheckStringOccurences.getTokenised(
				Set.of("rockstar", "rock", "star", "rocks", "tar", "super", "highway", "high", "way", "superhighway"));

		for (Entry<String, List<String>> entry : res.entrySet()) {
			System.out.print(entry.getKey() + "-");
			for (String str : entry.getValue()) {
				System.out.print(str + ",");
			}
			System.out.println();
		}
	}

	private Map<String, List<String>> getTokenised(Set<String> tokens) {
		if (null == tokens || tokens.size() == 0) {
			return null;
		}
		Map<String, List<String>> res = new HashMap<>();
		for (String token : tokens) {
			List<String> subRes = getTokenForString(token, tokens);
			if (null != subRes) {
				res.put(token, subRes);
			}
		}
		return res;

	}

	private List<String> getTokenForString(String token, Set<String> tokens) {

		if (cache.containsKey(token)) {
			return cache.get(token);
		}
		List<String> res = new ArrayList<>();
		char ch[] = token.toCharArray();

		String temp = "";
		for (int i = 0; i < ch.length; i++) {
			temp += ch[i];
			if (tokens.contains(temp)) { // rock
				res.add(temp);
				List<String> subRes = getTokenForString(token.substring(i + 1), tokens);
				if (null != subRes) {
					res.addAll(subRes);
				}
			}
		}
		cache.put(token, res);
		return res;
	}

}
