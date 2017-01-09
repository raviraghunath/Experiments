package Arrays;

import java.math.BigInteger;

public class DropingEggProblem {

	private static final int breakFloor = 54;

	public static void main(String[] args) {
	}

	
	
	private static boolean isBreak(int floor) {
		return floor < breakFloor ? false : true;
	}

}
