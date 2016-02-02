package Recursives;

public class NthFibonacciNumber {

	public static void main(String[] args) {
		
		method1(10);
		System.out.println();
		System.out.print(0+","+1+" ");
		method2(0, 1, 9);
	}

	private static void method1(int n){
		int n1 =0,n2=1,i=2;
		System.out.print(n1+",");
		System.out.print(n2+",");
		while(i<=n){
			i++;
			int t=n1+n2;
			System.out.print((n1+n2)+",");
			n1=n2;
			n2=t;
		}
	}
	
	private static void method2(int n1,int n2, int times){
		if(times==0)return;
		System.out.print(n1+n2+",");
		method2(n2, n1+n2, --times);
	}


}
