package Trees;

import java.util.HashSet;
import java.util.Set;

/*http://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
*/public class ConvertBT2CircularDoublyLL {

	public static void main(String[] args) {
		TreeNode node = TreeUtils.getTree();
		TreeUtils.inOrder(node);
		System.out.println();
		m2(m1(node));

	}

	private static TreeNode m1(TreeNode n) {
		if (n == null)
			return null;
		TreeNode lNode = null, rNode = null;
		if (n.left != null) {
			lNode = m1(n.left);
			TreeNode lrNode = getRightMost(lNode);
			n.left = lrNode;
			lrNode.right = n;
		}
		if (n.right != null) {
			rNode = m1(n.right);
			n.right = rNode;
			rNode.left = n;
		}
		return (lNode != null) ? lNode : n;
	}

	private static TreeNode getRightMost(TreeNode node) {
		Set<Integer> set = new HashSet<>();
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	private static void m2(TreeNode node) {
		Set<Integer> set = new HashSet<>();
		while (node != null && !set.contains(node)) {
			System.out.print(node.data + ", ");
			node = node.right;
		}
	}
}
