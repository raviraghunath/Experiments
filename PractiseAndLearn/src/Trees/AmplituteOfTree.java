package Trees;

public class AmplituteOfTree {
	/*
	 * amplitude of path P in tree T is the maximum difference between values of
	 * nodes on path P. The amplitude of tree T is the maximum amplitude of
	 * paths in T. If tree T is empty, then it does not have any paths and its
	 * amplitude is assumed to be 0. For example, the amplitude of a path
	 * consisting of nodes with values 5, 9, 4, 3 is 6, and the amplitude of a
	 * path consisting of nodes with values 9, 7, 1 is 8. The amplitude of the
	 * tree is 8, as no other path in it has a greater amplitude
	 */
	public static void main(String[] args) {
		TreeNode node = TreeUtils.getTree();
		System.out.println(getAmplitute(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private static int getAmplitute(TreeNode node, int max, int min) {
		if (node == null)
			return max - min;
		int max1 = node.data > max ? node.data : max;
		int min1 = node.data < min ? node.data : min;
		return Math.max(getAmplitute(node.left, max1, min1), getAmplitute(node.right, max1, min1));
	}

}
