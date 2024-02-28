package Others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] nums = { 3,3};
//		int[] res = twoSum.twoSum1(nums, 6);
//		System.out.println(res[0] + " " + res[1]);
		int res[] = twoSum.twoSum(nums, 6);
		System.out.println(res[0] + " " + res[1]);
	}

	public int[] twoSum1(int[] nums, int target) {
		int[] res = new int[2];
		Arrays.sort(nums);

		int p1 = 0;
		int p2 = nums.length - 1;

		while (p1 < p2) {
			if (nums[p1] + nums[p2] == target) {
				res[0] = p1;
				res[1] = p2;
				break;
			} else if (nums[p1] + nums[p2] < target) {
				p1++;
			} else if (nums[p1] + nums[p2] > target) {
				p2--;
			}
		}
		return res;
	}

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		if(nums.length<=1) {
			return res;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = i;
				res[1] = map.get(target - nums[i]);
			} else {
				map.put(nums[i], i);
			}
		}
		return res;
	}

}
