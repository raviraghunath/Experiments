package Arrays;

import java.util.Stack;

public class NextGreatElementInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[]= {98,23,54,12,20,7,27};
		method1(array);
	}
	
	private static void method1(int array[]){
		if(array==null||array.length==0){return;}
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(array[0]);
		for(int i=1,n=array.length;i<n;i++){
			int ele = array[i];
			while(ele>stack.peek()&&!stack.isEmpty()){
				System.out.println(stack.pop()+"->"+ele);
			}
			stack.push(ele);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+"->"+"null");
		}
	}

}
