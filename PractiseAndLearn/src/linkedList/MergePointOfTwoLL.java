package linkedList;

public class MergePointOfTwoLL {

	/*To run the below program*/
	/*Node n = LLUtils.getLL(new int[]{1,2,3});
	Node m = LLUtils.getLL(new int[]{11,12,13,14,15,16});
	Node mer = LLUtils.getLL(new int[]{111,112,113,114});
	n.getNextNode().getNextNode().setNextNode(mer);
	m.getNextNode().getNextNode().getNextNode().
	getNextNode().getNextNode().
	setNextNode(mer.getNextNode());
	
	Node su = MergePointOfTwoLL.getMergePoint(n, m);
	System.out.println(su);*/
	
	public static Node getMergePoint(Node n,Node m){
		if(n==null||m==null){return null;}
		if(n.getNextNode()==null||m.getNextNode()==null){return null;}

		int nLen = LLUtils.lengthOfLL(n);
		int mLen = LLUtils.lengthOfLL(m);
		
		int diff = Math.abs(nLen-mLen);
		Node BigLLPointer=n;
		Node ShortLLPointer=m;
		
		if(nLen<mLen){
			BigLLPointer=m;ShortLLPointer=n;
		}
		
		for(int i=1;i<=diff;i++){
			BigLLPointer=BigLLPointer.getNextNode();
		}
		
		while(true){
			if(BigLLPointer==null||ShortLLPointer==null)return null;
			if(BigLLPointer==ShortLLPointer)return BigLLPointer;
			BigLLPointer=BigLLPointer.getNextNode();
			ShortLLPointer=ShortLLPointer.getNextNode();
		}
	}
	
}
