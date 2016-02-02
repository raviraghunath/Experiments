package Trees;

public class TreeUtils {

	
	public static TreeNode getTree(){
		TreeNode node1= new TreeNode(1); 
		TreeNode node2= new TreeNode(2); 
		TreeNode node3= new TreeNode(3); 
		TreeNode node4= new TreeNode(4); 
		TreeNode node5= new TreeNode(5); 
		TreeNode node6= new TreeNode(6); 
		TreeNode node7= new TreeNode(7); 
		TreeNode node8= new TreeNode(8);
		TreeNode node9= new TreeNode(9);
		TreeNode node10= new TreeNode(10);
		TreeNode node11= new TreeNode(11);
		TreeNode node12= new TreeNode(12);
		TreeNode node13= new TreeNode(13);
		TreeNode node14= new TreeNode(14);
		TreeNode node15= new TreeNode(15);
		node2.left=node1;
		node2.right=node3;

		node5.left=node4;
		node5.right=node6;
		
		node7.left=node2;
		node7.right=node5;

		node8.left=node7;
		node8.right=node12;

		node12.left=node10;
		node12.right=node14;

		node10.left=node9;
		node10.right=node11;

		node14.left=node13;
		node14.right=node15;

		return node8;
	}

	
//				8
//		7		    			12
//	2             5	   		10			14
//1   	3      4     6   9  	11    13  15
	
	
	
	public static void inOrder(TreeNode node){
		if(node==null){return;}
		inOrder(node.left);
		System.out.print(node.data+",");
		inOrder(node.right);
	}
}
