package Trees;

public class LowestCommonAncestorOfTwoNodesBST {

	
	public static void main(String[] args) {
		TreeNode node = TreeUtils.getTree();
		LowestCommonAncestorOfTwoNodesBST a = new LowestCommonAncestorOfTwoNodesBST();
		
		a.n1 = new TreeNode(11);
		a.n2 = new TreeNode(15);
		
		System.out.println(a.method(node).data);
		
	}
	
	TreeNode n1, n2;
	
	private TreeNode method(TreeNode node){
		if(node==null)return null;
		if(node.data==n1.data||node.data==n2.data){
			return node;
		}else if(node.data>n1.data&&node.data<n2.data){
			return node;
		}
		if(node.data<n1.data){
			return method(node.right);
		}else{
			return method(node.left);
		}
	}

}
