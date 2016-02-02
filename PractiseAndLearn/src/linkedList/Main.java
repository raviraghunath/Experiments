package linkedList;

public class Main {

	
	public static void main(String[] args) {
		Node n = LLUtils.getLL(new int[]{1,2,3});
		Node m = LLUtils.getLL(new int[]{11,12,13,14,15,16});
		Node mer = LLUtils.getLL(new int[]{111,112,113,114});
		n.getNextNode().getNextNode().setNextNode(mer);
		m.getNextNode().getNextNode().getNextNode().
		getNextNode().getNextNode().
		setNextNode(mer.getNextNode());
		
		Node su = MergePointOfTwoLL.getMergePoint(n, m);
		System.out.println(su);
		
	}



}
