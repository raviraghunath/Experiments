package Experiment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

	public static TreeNode getTree() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		TreeNode node15 = new TreeNode(15);
		node2.left = node1;
		node2.right = node3;

		node5.left = node4;
		node5.right = node6;

		node7.left = node2;
		node7.right = node5;

		node8.left = node7;
		node8.right = node12;

		node12.left = node10;
		node12.right = node14;

		node10.left = node9;
		node10.right = node11;

		node14.left = node13;
		node14.right = node15;

		return node8;
	}

	public static TreeNode getCurrTree() {
		TreeNode node5 = new TreeNode(5);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node12 = new TreeNode(12);
		TreeNode node2 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);
		TreeNode node4 = new TreeNode(4);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);

		node5.left = node8;
		node5.right = node9;

		node8.left = node12;
		node8.right = node2;

		node9.left = node7;
		node9.right = node4;

		node7.left = node1;

		node4.left = node3;

		return node5;
	}

//				8
//		7		    			12
//	2             5	   		10			14
//1   	3      4     6   9  	11    13  15

	public static void dfs(TreeNode node) {
		if (null == node) {
			return;
		}
		dfs(node.left);
		System.out.println(node.val);
		dfs(node.right);
	}
	public static void bfs(TreeNode node) {
		if (null == node) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			TreeNode n = queue.poll();
			System.out.print(n.val +" ");
			if(n.left!=null)
			queue.add(n.left);
			if(n.right!=null)
			queue.add(n.right);
		}
	}

	public static void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.val + ",");
		inOrder(node.right);
	}
	
	public static void main(String[] args) {
		TreeNode node = getCurrTree();
		inOrder(node);
		System.out.println();
		List<Integer> list = new TreeUtils().inorderTraversal(node);
		for(Integer i : list) {
			System.out.print(i+" ");
		}
		System.out.println();
		bfs(node);
		System.out.println();
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		return inorderTraversal(root, new ArrayList<>());
	}

	public List<Integer> inorderTraversal(TreeNode root,List<Integer> list) {
		if(null == root) {
			return list;
		}
		inorderTraversal(root.left, list);
		list.add(root.val);
		inorderTraversal(root.right, list);
		return list;
	}
}
