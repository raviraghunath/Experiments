package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		NQueens nQueens = new NQueens();
		List<List<String>> res = nQueens.solveNQueens(5);
		for (List<String> strings : res) {
			for (String string : strings) {
				System.out.println(string);
			}
			System.out.println();
		}
	}

	private class Position {
		int i;
		int j;

		Position(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Position [i=" + i + ", j=" + j + "]";
		}

	}

	public List<List<String>> solveNQueens(int n) {
		List<List<Position>> res = new ArrayList<>();
		for (int j = 0; j < n; j++) {
			List<List<Position>> res1 = doProcess(n, new ArrayList<>(), new Position(0, j));
			if (null != res1) {
				res.addAll(res1);
			}
		}
		List<List<String>> resStr = new ArrayList<>();

		for (List<Position> positions : res) {
			List<String> strings = new ArrayList<>();
			for (Position position : positions) {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < n; i++) {
					builder.append(".");
				}
				char[] cs = builder.toString().toCharArray();
				cs[position.j] = 'Q';
				strings.add(position.i, new String(cs));
			}

			resStr.add(strings);
		}

		return resStr;
	}

	static int resCnt = 0;

	public List<List<Position>> doProcess(int n, List<Position> placed, Position pos) {
		 System.out.print(pos);
		if (canPlace(placed, pos)) {
			System.out.println(" : can place");
			List<List<Position>> res = new ArrayList<>();
			placed.add(pos);
			if (placed.size() == n) {
				System.out.println("last");
				resCnt++;
				res.add(placed);
				return res;
			}
			for (int j = 0; j < n; j++) {
				List<List<Position>> res1 = doProcess(n, new ArrayList<>(placed) , new Position(pos.i + 1, j));
				if (null != res1) {
					res.addAll(res1);
				}
			}
			return res;
		} else {
			System.out.println(" : cannot place");
		}
		return null;
	}

	public List<List<String>> solveNQueens1(int n) {
		List<List<String>> resPos = new ArrayList<>();
		int startCol = 0;

		while (startCol < n) {
			List<Position> currRes = new ArrayList<>();
			List<String> currResStr = new ArrayList<>();
			Position initailPos = new Position(0, startCol);
			currRes.add(initailPos);
			StringBuilder builder = new StringBuilder();
			int nn = 1;
			for (int ps = 0; ps < n; ps++) {
				builder.append(ps == startCol ? "Q" : ".");
			}
			currResStr.add(builder.toString());
			for (int i = 1; i < n; i++) {
				StringBuilder currBuilder = new StringBuilder();
				for (int j = 0; j < n; j++) {
					Position currPos = new Position(i, j);
					if (canPlace(currRes, currPos)) {
						currRes.add(currPos);
						currBuilder.append("Q");
						nn++;
					} else {
						currBuilder.append(".");
					}
				}
				currResStr.add(currBuilder.toString());
			}
			if (nn == n)
				resPos.add(currResStr);
			startCol++;
		}
		return resPos;
	}

	private boolean canPlace(List<Position> placed, Position pos) {
		if (placed.size() == 0)
			return true;
		for (Position p : placed) {
			if (p.i == pos.i || p.j == pos.j) {
				return false;
			}
			int pDiff = Math.abs(p.i - pos.i);
			int cDiff = Math.abs(p.j - pos.j);
			if (pDiff == cDiff) {
				return false;
			}
		}
		return true;
	}
}
