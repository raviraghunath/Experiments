package Others;
public class ValidBST {

	public static void main(String[] args) {
		ValidBST validBST = new ValidBST();
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode1_1 = new TreeNode(1);
		
		treeNode1.left= treeNode1_1;
		
		System.out.println(validBST.isValidBST(treeNode1));
	}

	public boolean isValidBST(TreeNode root) {
		if (null == root) {
			return true;
		}

		if ((root.right != null && leftMostValue(root.right) <= root.val)
				|| (root.left != null && rightMostValue(root.left) >= root.val)) {
			return false;
		}

		return isValidBST(root.left) && isValidBST(root.right);
	}

	private int leftMostValue(TreeNode node) {
		if (node.left != null) {
			return leftMostValue(node.left);
		}
		return node.val;
	}

	private int rightMostValue(TreeNode node) {
		if (node.right != null) {
			return leftMostValue(node.right);
		}
		return node.val;
	}

}
