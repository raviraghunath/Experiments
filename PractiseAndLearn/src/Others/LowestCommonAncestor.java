package Experiment;

public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (p.val == root.val || q.val == root.val) {
			return root;
		}

		TreeNode t1 = lowestCommonAncestor(root.left, p, q);
		TreeNode t2 = lowestCommonAncestor(root.right, p, q);

		return null != t1 && null != t2 ? root : null != t1 ? t1 : t2;
	}
}
