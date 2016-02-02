package Trees;

public class RemoveAllNodesWhichLieOnPathHavingSumLessThanK {

	public static void main(String[] args) {
		TreeNode node = TreeUtils.getTree();
		TreeUtils.inOrder(node);
		method1(node, 49);
		System.out.println();
		TreeUtils.inOrder(node);
	}

	private static boolean method1(TreeNode node, int tot){
		if(node.data>=tot)return true;
		boolean b = false;
		if(node.right!=null)b=method1(node.right, tot-node.data);
		boolean b1 = false;
		if(node.left!=null)b1=method1(node.left, tot-node.data);
		if(!b)node.right=null;
		if(!b1)node.left=null;
		return b||b1;
	}
}
