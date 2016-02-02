package Arrays;

public class LeadersInAnArray {

	public static void main(String[] args) {
		int []array={ 98, 23, 54, 12, 20, 7, 27};
		method1(array);
	}

	private static void method1(int[] array) {
		int max = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] > max) {
				System.out.println(array[i]);
				max = array[i];
			}
		}
	}

}
