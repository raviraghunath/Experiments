package Others;

public class GraphUtils {

	static GraphNode getGraph() {
		GraphNode graphNode1 = new GraphNode(1);
		GraphNode graphNode2 = new GraphNode(2);
		GraphNode graphNode3 = new GraphNode(3);
		GraphNode graphNode4 = new GraphNode(4);
		GraphNode graphNode5 = new GraphNode(5);
		GraphNode graphNode6 = new GraphNode(6);

		graphNode1.addNode(graphNode2, 2);
		graphNode1.addNode(graphNode3, 4);
		graphNode2.addNode(graphNode4, 7);
		graphNode2.addNode(graphNode3, 1);
		graphNode3.addNode(graphNode5, 3);
		graphNode5.addNode(graphNode6, 5);
		graphNode5.addNode(graphNode4, 2);
		graphNode4.addNode(graphNode6, 1);

		return graphNode1;
	}
	
	static GraphNode getGraphForTSM() {
		GraphNode graphNode1 = new GraphNode(1);
		GraphNode graphNode2 = new GraphNode(2);
		GraphNode graphNode3 = new GraphNode(3);
		GraphNode graphNode4 = new GraphNode(4);

		graphNode1.addNode(graphNode2, 10);
		graphNode1.addNode(graphNode3, 15);
		graphNode1.addNode(graphNode4, 20);

		graphNode2.addNode(graphNode1, 5);
		graphNode2.addNode(graphNode3, 9);
		graphNode2.addNode(graphNode4, 10);

		graphNode3.addNode(graphNode1, 6);
		graphNode3.addNode(graphNode2, 13);
		graphNode3.addNode(graphNode4, 12);

		graphNode4.addNode(graphNode1, 8);
		graphNode4.addNode(graphNode2, 8);
		graphNode4.addNode(graphNode3, 9);

		return graphNode1;
	}
	
	static GraphNode getGraphForTSM1() {
		GraphNode graphNodeA = new GraphNode('a');
		GraphNode graphNodeB = new GraphNode('b');
		GraphNode graphNodeC = new GraphNode('c');
		GraphNode graphNodeD = new GraphNode('d');
		GraphNode graphNodeE = new GraphNode('e');
		GraphNode graphNodeF = new GraphNode('f');

		graphNodeA.addNode(graphNodeB, 16);
		graphNodeB.addNode(graphNodeC, 21);
		graphNodeC.addNode(graphNodeD, 12);
		graphNodeD.addNode(graphNodeE, 15);
		graphNodeD.addNode(graphNodeB, 9);
		
		graphNodeE.addNode(graphNodeD, 15);
		graphNodeE.addNode(graphNodeF, 16);
		
		graphNodeF.addNode(graphNodeC, 7);
		graphNodeF.addNode(graphNodeE, 16);
		graphNodeF.addNode(graphNodeA, 34);
		

		return graphNodeA;
	}
}
