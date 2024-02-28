package Others;

public class BalancedBT {

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return 1 >= Math.abs(getHeight(root.left) - getHeight(root.right)) || ( isBalanced(root.left)&& isBalanced(root.right));
	}

	int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
}
