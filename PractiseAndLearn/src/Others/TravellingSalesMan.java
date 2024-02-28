package Others;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;


/*https://www.youtube.com/watch?v=XaXsJJh-Q5Y*/
public class TravellingSalesMan {

	public static void main(String[] args) {
		GraphNode graphNode = GraphUtils.getGraphForTSM1();
		TravellingSalesMan travellingSalesMan = new TravellingSalesMan();
		System.out.println(travellingSalesMan.getMinTSM(graphNode, 0, new HashSet<>(), graphNode));
	}

	int getMinTSM(GraphNode graphNode, int cost, Set<GraphNode> visitedNodes, GraphNode initialNode) {
		boolean processAnyOneChild = false;
		int min = Integer.MAX_VALUE;
		visitedNodes.add(graphNode);
		for (Entry<GraphNode, Integer> entry : graphNode.getNodes().entrySet()) {
			if (!visitedNodes.contains(entry.getKey())) {
				processAnyOneChild = true;
				Set<GraphNode> tempSet = new HashSet<>(visitedNodes);
				int res = getMinTSM(entry.getKey(), cost + entry.getValue(), tempSet, initialNode);
				if (res < min) {
					min = res;
				}
			}
		}
		if (!processAnyOneChild) {
			boolean isInitialConnected = false;
			for (Entry<GraphNode, Integer> entry : graphNode.getNodes().entrySet()) {
				if (entry.getKey().equals(initialNode)) {
					isInitialConnected = true;
					min = cost + entry.getValue();
					break;
				}
			}
			if (!isInitialConnected) {
				return Integer.MAX_VALUE;
			}
		}
		return min;
	}
}
