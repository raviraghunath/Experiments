package PokerGame;

public class PokerGameproblem54_Obj implements Comparable<PokerGameproblem54_Obj> {

	int num;
	char sym;

	PokerGameproblem54_Obj(int num, char sym) {
		this.num = num;
		this.sym = sym;
	}

	@Override
	public int compareTo(PokerGameproblem54_Obj o) {
		return (this.num > o.num) ? 1 : -1;
	}

	@Override
	public String toString() {
		return "Obj [num=" + num + ", sym=" + sym + "]";
	}

}
