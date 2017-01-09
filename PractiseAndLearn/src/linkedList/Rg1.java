package linkedList;

public class Rg1 {

	public static void main(String args[]) {
		Node n1 = new Node(-9);
		Node n2 = new Node(-1);
		Node n3 = new Node(3);
		Node n4 = new Node(-2);
		Node n5 = new Node(-7);
		Node n6 = new Node(5);

		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		n4.setNextNode(n5);
		n5.setNextNode(n6);
		System.out.println("Before segregation");
		LLUtils.printLL(n1);
		segergate(n1);
	}

	private static void segergate(Node node) {
		Node firstPositive = null;
		Node firstNegative = null;
		Node lastPositive = null;
		Node lastNegative = null;
		while (node != null) {
			boolean b = false;
			if (node.getData() >= 0) {
				if (firstPositive == null) {
					firstPositive = node;
					if (firstNegative != null) {
						Node n1 = node.getNextNode();
						node.setNextNode(firstNegative);
						lastNegative.setNextNode(n1);
						lastPositive = node;
						node = lastNegative;
						b = true;
					}
				}
				if (lastPositive == null) {
					lastPositive = node;
				}
				if (!b && lastNegative != null) {
					Node n1 = lastPositive.getNextNode();
					Node n2 = node.getNextNode();
					lastPositive.setNextNode(node);
					node.setNextNode(n1);
					lastNegative.setNextNode(n2);
					lastPositive = node;
					node = lastNegative;
				}

			} else {
				if (firstNegative == null)
					firstNegative = node;
				lastNegative = node;
			}
			node = node.getNextNode();
		}
		System.out.println("After segregation");
		LLUtils.printLL(firstPositive);
	}
}
