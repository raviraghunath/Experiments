package Trees;

public class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(){
		
	}
	TreeNode(int data){
		this.data=data;
	}
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right
				+ "]";
	}
}

class TreeNodeWithParent {
	int data;
	TreeNodeWithParent(int data){
		this.data=data;
	}
	TreeNodeWithParent left;
	TreeNodeWithParent right;
	TreeNodeWithParent parent;
	@Override
	public String toString() {
		return "TreeNodeWithParent [data=" + data + ", left=" + left
				+ ", right=" + right + ", parent=" + parent + "]";
	}
}