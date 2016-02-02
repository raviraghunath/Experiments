package linkedList;

import java.util.HashMap;

public class FindnRemoveLoopInLL {
	
		private static boolean isLoopDetected(Node n){
		if(n==null||n.getNextNode()==null){return false;}
		Node slowPointer=n;
		Node fastPointer=n.getNextNode().getNextNode();
		while(true){
			if(slowPointer==fastPointer){return true;}
			if(fastPointer==null||fastPointer.getNextNode()==null){return false;}
			slowPointer=slowPointer.getNextNode();
			fastPointer=fastPointer.getNextNode().getNextNode();
		}
	}
	
	private static Node findLoopStart(Node n){
		if(n==null||n.getNextNode()==null){return null;}
		Node slowPointer=n.getNextNode();
		Node fastPointer=n.getNextNode().getNextNode();
		while(true){
			if(slowPointer==fastPointer){break;}
			if(fastPointer==null||fastPointer.getNextNode()==null){return null;}
			slowPointer=slowPointer.getNextNode();
			fastPointer=fastPointer.getNextNode().getNextNode();
		}
		slowPointer=n;
		while(slowPointer!=fastPointer){
			slowPointer=slowPointer.getNextNode();
			fastPointer=fastPointer.getNextNode();
		}
		return slowPointer;
	}

	private static Node findLoopStartHashMap(Node n){
		if(n==null)return null;
		Node pointer = n;
		HashMap<Node, Boolean> map = new HashMap<Node, Boolean>();
		while(!map.containsKey(pointer)){
			map.put(pointer, true);
			pointer=pointer.getNextNode();
			if(pointer==null){return null;}
		}
		return pointer;
	}

	private static void findNRemoveLoop(Node n){
		if(n==null||n.getNextNode()==null){return ;}
		Node slowPointer=n.getNextNode();
		Node fastPointer=n.getNextNode().getNextNode();
		while(true){
			if(slowPointer==fastPointer){break;}
			if(fastPointer==null||fastPointer.getNextNode()==null){return;}
			slowPointer=slowPointer.getNextNode();
			fastPointer=fastPointer.getNextNode().getNextNode();
		}
		slowPointer=n;
		Node toBeCutToAvoidLoop=null;
		while(slowPointer!=fastPointer){
			slowPointer=slowPointer.getNextNode();
			toBeCutToAvoidLoop = fastPointer;
			fastPointer=fastPointer.getNextNode();
		}
		if(toBeCutToAvoidLoop!=null)
			toBeCutToAvoidLoop.setNextNode(null);
	}


}
