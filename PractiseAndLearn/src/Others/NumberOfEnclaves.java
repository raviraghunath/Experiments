package Others;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Pos {
	int i;
	int j;

	public Pos(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public int hashCode() {
		return Objects.hash(i, j);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pos other = (Pos) obj;
		return i == other.i && j == other.j;
	}
}

/* https://leetcode.com/problems/number-of-enclaves/description/ */
public class NumberOfEnclaves {

	public static void main(String[] args) {
		NumberOfEnclaves enclaves = new NumberOfEnclaves();

//		int[][] num = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int[][] num = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };

	}

	public int numEnclaves(int[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (!positions.contains(new Pos(i, j))
						&& (i * j == 0 || i == grid.length - 1 || j == grid[i].length - 1)) {
					System.out.println(i + " - " + j);
					popluate(grid, i, j);
				}
			}

		}
		int cnt = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1 && !positions.contains(new Pos(i, j))) {
					cnt++;
				}
			}

		}

		return cnt;
	}

	Set<Pos> positions = new HashSet<>();

	void popluate(int[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[i].length) {
			return;
		}
		if (!positions.contains(new Pos(i, j)) && grid[i][j] == 1) {
			positions.add(new Pos(i, j));
			popluate(grid, i + 1, j);
			popluate(grid, i - 1, j);
			popluate(grid, i, j + 1);
			popluate(grid, i, j - 1);
		}
	}

}
