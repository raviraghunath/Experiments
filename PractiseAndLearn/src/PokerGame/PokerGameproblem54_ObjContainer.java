package PokerGame;

import java.util.ArrayList;
import java.util.List;

import PokerGame.PokerGameproblem54_Helper.PWIN;
import PokerGame.PokerGameproblem54_Helper.res;

public class PokerGameproblem54_ObjContainer implements Comparable<PokerGameproblem54_ObjContainer> {
	List<PokerGameproblem54_Obj> list = new ArrayList<>(5);

	@Override
	public int compareTo(PokerGameproblem54_ObjContainer o) {
		res r1 = PWIN.getPoint(this);
		res r2 = PWIN.getPoint(o);
		if (r1.pwin.points > r2.pwin.points)
			return 1;
		else if (r1.pwin.points < r2.pwin.points)
			return -1;
		else {
			if(r1.num!=0){
				int n = r1.num - r2.num;
				if (n != 0)
					return n;
			}
			int hand = PWIN.getHighCardOf2(this, o);
			return hand == 1 ? 1 : -1;
		}
	}

}
