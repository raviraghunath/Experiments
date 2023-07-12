package Experiment;

import java.util.ArrayList;
import java.util.List;

/*https://leetcode.com/problems/path-sum-iii/*/
public class BTPathSum {

	public static void main(String[] args) {
		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node_3 = new TreeNode(-3);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node11 = new TreeNode(11);
		TreeNode node3_1 = new TreeNode(3);
		TreeNode node_2 = new TreeNode(-2);
		TreeNode node1 = new TreeNode(1);

		node10.left = node5;
		node10.right = node_3;
		node5.left = node3;
		node5.right = node2;
		node_3.right = node11;
		node3.left = node3_1;
		node3.right = node_2;
		node2.right = node1;

		BTPathSum pathSum = new BTPathSum();
		System.out.println(pathSum.pathSum(node10, 8, new ArrayList<>()));
	}

	public int pathSum(TreeNode root, int targetSum, List<Integer> arr) {
		int res = 0;
		if (root == null) {
			return res;
		}
		List<Integer> arr1 = new ArrayList<>(arr);
		arr1.add(root.val);
		res = hasSubArrayWithSumStartingLastIndex(arr1, targetSum);
		
		if(root.left!=null) {
			res += pathSum(root.left, targetSum, new ArrayList<>(arr1));
		}
		if(root.right!=null) {
			res += pathSum(root.right, targetSum, new ArrayList<>(arr1));
		}
		return res;

	}
	
	public int hasSubArrayWithSumStartingLastIndex(List<Integer> arr, int sum) {
		int currSum = 0;
		for (int i = arr.size() - 1; i >= 0; i--) {
			currSum += arr.get(i);
		}
		int res = 0;
		if (currSum == sum) {
			res++;
		}
		for (int i = 0; i < arr.size() - 1; i++) {
			currSum -= arr.get(i);
			if (currSum == sum) {
				res++;
			}
		}
		return res;
	}

}
