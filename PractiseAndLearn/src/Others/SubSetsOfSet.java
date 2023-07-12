package Experiment;

import java.util.ArrayList;
import java.util.List;

public class SubSetsOfSet {

	public List<List<Integer>> subsets(int[] nums) {
		return subsets(nums, 0, new ArrayList<>());
	}

	public List<List<Integer>> subsets(int[] nums, int i, List<Integer> list) {
		List<List<Integer>> res = new ArrayList<>();
		if (i == nums.length) {
			res.add(list);
			return res;
		}
		List<Integer> l1 = new ArrayList<>(list);
		res.addAll(subsets(nums, i + 1, l1));
		List<Integer> l2 = new ArrayList<>(list);
		l2.add(nums[i]);
		res.addAll(subsets(nums, i + 1, l2));
		return res;
	}
	
}
