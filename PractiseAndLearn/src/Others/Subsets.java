package Experiment;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		List<List<Integer>> list = subsets.subsets(new int[] { 1, 2, 3 });

		for (List<Integer> list1 : list) {
			for (Integer integer : list1) {
				System.out.print(integer + ",");
			}
			System.out.println();
		}
	}

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
