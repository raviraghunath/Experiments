package linkedList;

public class LLUtils {

	public static Node getLL(boolean isCircular){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		n4.setNextNode(n5);
		n5.setNextNode(n6);
		n6.setNextNode(n7);
		n7.setNextNode(n8);
		n8.setNextNode(n9);
		n9.setNextNode(n10);
		n10.setNextNode(null);
		if(isCircular)n10.setNextNode(n7);
		return n1;
	}
	
	public static void printLL(Node n){
		if(n==null){System.out.println("null");return;}
		System.out.print(n.getData()+"->");
		printLL(n.getNextNode());
	}
	
	public static int lengthOfLL(Node n){
		return n==null?0:lengthOfLL(n.getNextNode())+1;
	}

	public static Node getLL(int[] val){
		if(val==null||val.length==0){return null;}
		Node n = new Node(val[0]);
		Node startNode = n;
		for(int i=1;i<val.length;i++){
			Node m = new Node(val[i]);
			n.setNextNode(m);
			n=m;
		}
		return startNode;
	}

	public static void get2MergeLL(){
		Node n = getLL(new int[]{1,2,3});
		Node m = getLL(new int[]{11,12,13,14});
		Node mer = getLL(new int[]{111,112,113,114});
		n.getNextNode().getNextNode().setNextNode(mer);
		m.getNextNode().getNextNode().getNextNode().setNextNode(mer);
		
	}
}
