package Experiment;

public class SubTreeExists {

	boolean isSubTree(TreeNode t1, TreeNode t2) {
		if (t1 == null || t2 == null) {
			return false;
		}
		boolean b = false;
		if (t1.val == t2.val) {
			b = isTreeEqauls(t1, t2);
		}
		if(b) return true;
		return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);

	}

	boolean isTreeEqauls(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		if (t1.val != t2.val) {
			return false;
		}
		return isTreeEqauls(t1.left, t2.left) && isTreeEqauls(t1.right, t2.right);
	}

}
