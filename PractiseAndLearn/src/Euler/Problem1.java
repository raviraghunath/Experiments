package Euler;

public class Problem1 {

	public static void main(String[] args) {
		System.out.println(m1(1000));
	}
	
	private static int m1(int limit){
		int sum =0;
		for(int i=1;i<limit;i++){
				if(i%3==0||i%5==0)sum+=i;
		}
		return sum;
	}

}
