package Experiment;

public class ReverseLL {

	public static void main(String[] args) {
		ReverseLL reverseLL = new ReverseLL();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);

		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;

		ListNode tNode = listNode1;
		while (tNode != null) {
			System.out.print(tNode.data + "->");
			tNode = tNode.next;
		}
		System.out.println();

		ListNode rNode1  = reverseLL.reverseList(listNode1);
		tNode = rNode1;
		while (tNode != null) {
			System.out.print(tNode.data + "->");
			tNode = tNode.next;
		}
		System.out.println();

		ListNode rNode2   = reverseLL.reverseLLIterative(rNode1);
		tNode = rNode2;
		while (tNode != null) {
			System.out.print(tNode.data + "->");
			tNode = tNode.next;
		}
	}

	private ListNode reverseLLIterative(ListNode node) {
		if (null == node) {
			return null;
		}
		ListNode currNode = node;
		ListNode next = currNode.next;
		currNode.next = null;
		while (next != null) {
			ListNode t = next.next;
			next.next = currNode;
			currNode = next;
			next = t;
		}
		return currNode;
	}

	public ListNode reverseList(ListNode head) {
		ListNode node = head;
		while (node.next != null) {
			node = node.next;
		}
		reverseLL(head);
		return node;

	}

	private ListNode reverseLL(ListNode node) {
		if (null == node) {
			return null;
		} else {
			if (null != node.next) {
				ListNode node1 = reverseLL(node.next);
				node.next = null;
				node1.next = node;
				return node;
			} else {
				return node;
			}
		}

	}
}
