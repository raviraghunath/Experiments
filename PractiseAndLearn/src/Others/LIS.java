package Experiment;

import java.util.HashMap;
import java.util.Map;

public class LIS {
	public static void main(String[] args) {
		LIS lis = new LIS();
		System.out.println(lis.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}

	public int lengthOfLIS(int[] nums) {
		return lengthOfLIS(nums, 0, Integer.MIN_VALUE, new HashMap<Integer, Map<Integer, Integer>>());
	}

	public int lengthOfLIS(int[] nums, int i, int prevValue, Map<Integer, Map<Integer, Integer>> cache) {
		Map<Integer, Integer> prevMap = cache.get(i);
		if (prevMap != null) {
			Integer cVal = prevMap.get(prevValue);
			if (cVal != null) {
				return cVal;
			}
		}
		if (i == nums.length) {
			return 0;
		}
		int res = 0;
		if (prevValue < nums[i]) {
			res = Math.max(1 + lengthOfLIS(nums, i + 1, nums[i], cache), lengthOfLIS(nums, i + 1, prevValue, cache));
		} else {
			res = lengthOfLIS(nums, i + 1, prevValue, cache);
		}
		if (prevMap == null) {
			prevMap = new HashMap<Integer, Integer>();
			cache.put(i, prevMap);
		}
		prevMap.put(prevValue, res);
		return res;
	}
	
	
	
}
