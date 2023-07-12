package Experiment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GraphNode {

	private Object c;
	private Map<GraphNode, Integer> nodes = new HashMap<>();

	public GraphNode(Object c) {
		this.c = c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(c);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		return Objects.equals(c, other.c);
	}

	public void addNode(GraphNode graphNode, int dist) {
		nodes.put(graphNode, dist);
	}

	public Object getC() {
		return c;
	}

	public void setC(Object c) {
		this.c = c;
	}

	public Map<GraphNode, Integer> getNodes() {
		return nodes;
	}

	public void setNodes(Map<GraphNode, Integer> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "GraphNode [c=" + c + "]";
	}

}
