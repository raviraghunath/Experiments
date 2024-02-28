package Others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class dijkstrasAlgo {

	class data {
		int val;
		boolean isProcessed;
		GraphNode parent;

		data(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		new dijkstrasAlgo().dijkstra(GraphUtils.getGraph());
		System.out.println("***");
		new dijkstrasAlgo().dijkstraV1(GraphUtils.getGraph());
	}

	public void dijkstra(GraphNode src) {

		if (src == null) {
			return;
		}

		Map<GraphNode, data> tab = new HashMap<>();
		Set<GraphNode> visited = new HashSet<>();
		Set<GraphNode> nonVisited = new HashSet<>();
		populate(src, nonVisited);
		tab.put(src, new data(0));

		while (!nonVisited.isEmpty()) {
			GraphNode curr = getMin(tab);
			if (curr == null)
				break;
			for (Entry<GraphNode, Integer> entry : curr.getNodes().entrySet()) {
				if (tab.get(entry.getKey()) == null
						|| tab.get(entry.getKey()).val > tab.get(curr).val + entry.getValue()) {
					data d = new data(tab.get(curr).val + entry.getValue());
					tab.put(entry.getKey(), d);
				}
			}
			visited.add(curr);
			nonVisited.remove(curr);
			tab.get(curr).isProcessed = true;
		}

		for (Entry<GraphNode, data> entry : tab.entrySet()) {
			System.out.println(entry.getKey().getC() + " - " + entry.getValue().val);
		}
	}

	GraphNode getMin(Map<GraphNode, data> tab) {
		Entry<GraphNode, data> min = null;
		for (Entry<GraphNode, data> entry : tab.entrySet()) {
			if (!entry.getValue().isProcessed && (null == min || entry.getValue().val < min.getValue().val)) {
				min = entry;
			}
		}
		return null == min ? null : min.getKey();
	}

	void populate(GraphNode src, Set<GraphNode> nonVisited) {
		nonVisited.add(src);
		for (GraphNode graphNode : src.getNodes().keySet()) {
			populate(graphNode, nonVisited);
		}
	}

	public void dijkstraV1(GraphNode src) {
		if (src == null) {
			return;
		}

		Set<GraphNode> visited = new HashSet<>();
		Set<GraphNode> nonVisited = new HashSet<>();
		populate(src, nonVisited);
		Map<GraphNode, data> tab = new HashMap<>();
		tab.put(src, new data(0));

		while (!nonVisited.isEmpty()) {
			GraphNode graphNode = getMin(tab);
			if (graphNode == null)
				break;
			for (Entry<GraphNode, Integer> entry : graphNode.getNodes().entrySet()) {
				if (tab.get(entry.getKey()) == null
						|| tab.get(graphNode).val + entry.getValue() < tab.get(entry.getKey()).val) {
					tab.put(entry.getKey(), new data(tab.get(graphNode).val + entry.getValue()));
				}
			}
			visited.add(graphNode);
			nonVisited.remove(graphNode);
			tab.get(graphNode).isProcessed = true;
		}
		for (Entry<GraphNode, data> entry : tab.entrySet()) {
			System.out.println(entry.getKey().getC() + " - " + entry.getValue().val);
		}

	}

	class data1 {
		GraphNode src;
		int val;
		boolean isProcessed;
		GraphNode parent;

		data1(GraphNode src, int val) {
			this.src = src;
			this.val = val;
		}
	}

}
