package PokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PokerGameproblem54_Helper {

	static enum PWIN {
		Royal_Flush(RF, 100), Straight_Flush(SF, 99), FourKind(FK, 98), FullHouse(FH, 97), Flush(flush, 96),
		Straight(straight, 95), TreeKind(TK, 94), TwoPair(TP, 93), OnePair(OP, 92), Default(null, 0);
		criteriaFunction func;
		int points;

		PWIN(criteriaFunction func, int points) {
			this.func = func;
			this.points = points;
		}

		static res getPoint(PokerGameproblem54_ObjContainer container) {
			List<PokerGameproblem54_Obj> L1 = container.list;
			Collections.sort(L1);
			for (PWIN pw : PWIN.values()) {
				if (pw == PWIN.Default)
					continue;
				res r = pw.func.isWin(L1);
				if (r.bool) {
					r.pwin = pw;
					return r;
				}
			}
			res r = new res(false, 0, ' ');
			r.pwin = PWIN.Default;
			return r;
		}

		static int getHighCardOf2(PokerGameproblem54_ObjContainer container1,
				PokerGameproblem54_ObjContainer container2) {
			List<PokerGameproblem54_Obj> L1 = container1.list;
			List<PokerGameproblem54_Obj> L2 = container2.list;
			Collections.sort(L1);
			Collections.sort(L2);
			for (int i = L1.size() - 1; i >= 0; i--) {
				if (L1.get(i).num > L2.get(i).num)
					return 1;
				if (L1.get(i).num < L2.get(i).num)
					return 2;
			}
			return 0;
		}

	}

	interface criteriaFunction {
		res isWin(List<PokerGameproblem54_Obj> objs);
	}

	static criteriaFunction RF = new criteriaFunction() {

		@Override
		public res isWin(List<PokerGameproblem54_Obj> objs) {
			char sym = objs.get(0).sym;
			int num = objs.get(0).num;
			if (num != 10)
				return new res(false, 0, ' ');
			int i = 0;
			for (PokerGameproblem54_Obj obj : objs) {
				if (i == 0) {
					i++;
					continue;
				}
				if (sym != obj.sym)
					return new res(false, 0, ' ');
				if (num >= obj.num)
					return new res(false, 0, ' ');
				;
				num = obj.num;
			}
			return new res(true, 0, ' ');
		}
	};

	static criteriaFunction SF = new criteriaFunction() {

		@Override
		public res isWin(List<PokerGameproblem54_Obj> objs) {
			char sym = objs.get(0).sym;
			int num = objs.get(0).num;
			for (PokerGameproblem54_Obj obj : objs) {
				if (sym != obj.sym)
					return new res(false, 0, ' ');
				if (num != obj.num && num != obj.num - 1)
					return new res(false, 0, ' ');
				num = obj.num;
			}
			return new res(true, 0, ' ');
		}
	};

	static criteriaFunction FH = new criteriaFunction() {
		@Override
		public res isWin(List<PokerGameproblem54_Obj> objs) {
			int[] arr = getEmptyInitialisedArray();
			for (PokerGameproblem54_Obj obj : objs) {
				arr[obj.num]++;
			}
			boolean threeKind = false, twoPair = false;
			int numVal = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 3) {
					threeKind = true;
					numVal = i;
				}
				if (arr[i] == 2)
					twoPair = true;
			}
			return (threeKind && twoPair) ? new res(true, numVal, ' ') : new res(false, 0, ' ');
		}
	};

	static int[] getEmptyInitialisedArray() {
		int[] arr = new int[15];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		return arr;
	}

	static criteriaFunction FK = new criteriaFunction() {

		@Override
		public res isWin(List<PokerGameproblem54_Obj> objs) {
			int[] arr = getEmptyInitialisedArray();
			for (PokerGameproblem54_Obj obj : objs) {
				arr[obj.num]++;
			}
			boolean fourKind = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 4)
					fourKind = true;
			}
			return (fourKind) ? new res(true, 0, ' ') : new res(false, 0, ' ');
		}
	};

	static criteriaFunction flush = new criteriaFunction() {

		@Override
		public res isWin(List<PokerGameproblem54_Obj> objs) {
			char sym = objs.get(0).sym;
			for (PokerGameproblem54_Obj obj : objs) {
				if (sym != obj.sym)
					return new res(false, 0, ' ');
				sym = obj.sym;
			}
			return new res(true, 0, sym);
		}
	};

	static criteriaFunction straight = new criteriaFunction() {

		@Override
		public res isWin(List<PokerGameproblem54_Obj> objs) {
			int num = objs.get(0).num;
			int i = 0;
			for (PokerGameproblem54_Obj obj : objs) {
				if (i == 0) {
					i++;
					continue;
				}
				if (num + 1 != obj.num) {
					return new res(false, 0, ' ');
				}
				num = obj.num;
			}
			return new res(true, 0, ' ');
		}
	};

	static criteriaFunction TK = new criteriaFunction() {

		@Override
		public res isWin(List<PokerGameproblem54_Obj> objs) {
			int[] arr = getEmptyInitialisedArray();
			for (PokerGameproblem54_Obj obj : objs) {
				arr[obj.num]++;
			}
			boolean threeKind = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 3)
					threeKind = true;
			}
			return (threeKind) ? new res(true, 0, ' ') : new res(false, 0, ' ');
		}
	};

	static criteriaFunction TP = new criteriaFunction() {

		@Override
		public res isWin(List<PokerGameproblem54_Obj> objs) {
			int[] arr = getEmptyInitialisedArray();
			for (PokerGameproblem54_Obj obj : objs) {
				arr[obj.num]++;
			}
			boolean firstPair = false, secondPair = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 2) {
					if (!firstPair) {
						firstPair = true;
					} else {
						secondPair = true;
					}
				}
			}
			return (firstPair && secondPair) ? new res(true, 0, ' ') : new res(false, 0, ' ');
		}
	};

	static criteriaFunction OP = new criteriaFunction() {

		@Override
		public res isWin(List<PokerGameproblem54_Obj> objs) {
			int[] arr = getEmptyInitialisedArray();
			for (PokerGameproblem54_Obj obj : objs) {
				arr[obj.num]++;
			}
			boolean firstPair = false;
			int i = 0;
			for (; i < arr.length; i++) {
				if (arr[i] == 2) {
					firstPair = true;
					break;
				}
			}
			return (firstPair) ? new res(true, i, ' ') : new res(false, 0, ' ');
		}

	};

	public static void main(String args[]) {
		PokerGameproblem54_Helper gameproblem54_Helper = new PokerGameproblem54_Helper();
		List<PokerGameproblem54_Obj> objs1 = new ArrayList<>();
		objs1.add(new PokerGameproblem54_Obj(7, 'H'));
		objs1.add(new PokerGameproblem54_Obj(3, 'D'));
		objs1.add(new PokerGameproblem54_Obj(2, 'C'));
		objs1.add(new PokerGameproblem54_Obj(6, 'D'));
		objs1.add(new PokerGameproblem54_Obj(7, 'S'));
		System.out.println(gameproblem54_Helper.OP.isWin(objs1));
	}

	static class res {
		boolean bool;
		int num;
		char sym;
		PWIN pwin;

		@Override
		public String toString() {
			return "res [bool=" + bool + ", num=" + num + ", sym=" + sym + "]";
		}

		res(boolean bool,
				int num,
				char sym) {
			this.bool = bool;
			this.num = num;
			this.sym = sym;
		}
	}

}
