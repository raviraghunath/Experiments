package linkedList;

public class ReverseLinkedListIterative {

	public static void main(String[] args) {
		Node node = LLUtils.getLL(false);
		Node lastNode = node;
		while(lastNode.getNextNode()!=null){
			lastNode=lastNode.getNextNode();
		}
		LLUtils.printLL(node);
		reverse(node);
		LLUtils.printLL(lastNode);
	}

	private static void reverse(Node node){
		Node curr = node;
		Node pr =null;
		while(curr!=null){
			Node t  = curr.getNextNode();
			curr.setNextNode(pr);
			pr = curr;
			curr = t;
		}
	}
}
