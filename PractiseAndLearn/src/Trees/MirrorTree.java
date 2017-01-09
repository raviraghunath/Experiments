package Trees;

public class MirrorTree {

	public static void main(String[] args) {
		TreeNode node7 = new TreeNode(7);
		TreeNode node5 = new TreeNode(5);
		TreeNode node9 = new TreeNode(9);

		TreeNode node4 = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);

		TreeNode node8 = new TreeNode(8);
		TreeNode node10 = new TreeNode(10);

		node7.left = node5;
		node7.right = node9;

		node5.left = node3;
		node5.right = node4;

		node9.left = node8;
		node9.right = node10;

		TreeUtils.inOrder(node7);
		System.out.println();
		mirror(node7);
		TreeUtils.inOrder(node7);
	}

	private static void mirror(TreeNode node) {
		if (node.left == null && node.right == null)
			return;
		TreeNode temp = node.right;
		node.right = node.left;
		node.left = temp;
		mirror(node.left);
		mirror(node.right);
	}

}
