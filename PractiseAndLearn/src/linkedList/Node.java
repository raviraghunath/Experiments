package linkedList;

public class Node {
	private final int data;
	private Node nextNode;
	public Node(int data){
		this.data=data;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public int getData() {
		return data;
	}
	public Node getNextNode() {
		return nextNode;
	}
	
	
	
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}

	
	
}
