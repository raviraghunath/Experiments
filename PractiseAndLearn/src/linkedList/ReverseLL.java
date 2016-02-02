package linkedList;

public class ReverseLL {

	public static void main(String args[]){
		Node n = LLUtils.getLL(false);
		Node lastNode = n;
		while(lastNode.getNextNode()!=null){
			lastNode=lastNode.getNextNode();
		}
		LLUtils.printLL(n);
		Node m = reverseLLRecursive(n);
		LLUtils.printLL(lastNode);
	}
	
	public static Node reverseLLRecursive(Node n){
		if(n==null||n.getNextNode()==null)return n;
		Node m = reverseLLRecursive(n.getNextNode());
		m.setNextNode(n);
		n.setNextNode(null);
		return n;
	}
	
	public static Node reversaLLLoop(Node n){
		if(n!=null&&n.getNextNode()!=null){
			Node currNode = n;
			while(currNode!=null){
				Node nxtNode = currNode.getNextNode();
				currNode = currNode.getNextNode();
			}
		}
		return null;
	}
	
}
