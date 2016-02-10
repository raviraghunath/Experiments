package linkedList;

public class ReverseLinkedListRecursive {

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

	private static Node reverse(Node node) {
		if(node == null||node.getNextNode()==null){
			return node;
		}
		reverse(node.getNextNode()).setNextNode(node);
		node.setNextNode(null);
		return node;
	}
}
