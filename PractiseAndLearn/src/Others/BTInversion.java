package Experiment;

public class BTInversion {
	
	
	public static void main(String[] args) {
		BTInversion btInversion = new BTInversion();
		TreeNode node = TreeUtils.getTree();
		TreeUtils.inOrder(node);
		System.out.println("\n***");
		btInversion.invert(node);
		TreeUtils.inOrder(node);
		System.out.println("\n***");
		btInversion.invert(node);
		TreeUtils.inOrder(node);
	}

	void invert(TreeNode node) {
		if (node == null)
			return;
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		invert(node.left);
		invert(node.right);
	}

}
