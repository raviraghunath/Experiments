package Others;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {

	}

	public TreeNode(int data) {
		this.val = data;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + val + ", left=" + left + ", right=" + right + "]";
	}
}

class TreeNodeWithParent {
	int data;

	TreeNodeWithParent(int data) {
		this.data = data;
	}

	TreeNodeWithParent left;
	TreeNodeWithParent right;
	TreeNodeWithParent parent;

	@Override
	public String toString() {
		return "TreeNodeWithParent [data=" + data + ", left=" + left + ", right=" + right + ", parent=" + parent + "]";
	}
}