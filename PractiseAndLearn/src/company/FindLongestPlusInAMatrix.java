package company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * 
 * 
0,0,1,0,0
0,0,1,1,0
1,1,1,1,1
0,0,1,1,0
0,0,1,0,0


0,0,1,0,0,0,0
0,0,1,1,0,0,0
1,1,1,1,1,0,0
0,0,1,1,0,1,0
0,0,1,0,0,1,0
0,0,0,0,1,1,1
0,0,0,0,0,1,0


1) Rememebring the side navigation length.

*/

class NavigationLength {

	int leftLen;
	int righttLen;
	int topLen;
	int bottomLen;

	public NavigationLength(int leftLen, int righttLen, int topLen, int bottomLen) {
		this.leftLen = leftLen;
		this.righttLen = righttLen;
		this.topLen = topLen;
		this.bottomLen = bottomLen;
	}
}

class MatrisPos {

	int i;
	int j;

	MatrisPos(int i, int j) {
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
		MatrisPos other = (MatrisPos) obj;
		return i == other.i && j == other.j;
	}

}

public class FindLongestPlusInAMatrix {

	public static void main(String[] args) {
		FindLongestPlusInAMatrix findLongestPlusInAMatrix = new FindLongestPlusInAMatrix();
//		int l = findLongestPlusInAMatrix.getMaxPlusSize(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 1, 1, 0 },
//				{ 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0 }, { 0, 0, 1, 0, 0 } });
//		System.out.println("L : " + l);
		
		int l1 = findLongestPlusInAMatrix.getMaxPlusSize(2,new int[][]{{0,0},{0,1},{1,0}});
		System.out.println("L1 : " + l1);
	}

	int getMaxPlusSize(int n, int[][] mines) {
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = 1;
			}
		}
		for (int i = 0; i < mines.length; i++) {
			matrix[mines[i][0]][mines[i][1]] = 0;
		}
		return getMaxPlusSize(matrix);
	}

	int getMaxPlusSize(int[][] matrix) {
		Map<MatrisPos, NavigationLength> cache = new HashMap<MatrisPos, NavigationLength>();

		// base condition
		int maxLength = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				boolean center = areWeAtCenter(matrix, i, j);
				System.out.println("i : " + i + ", j : " + j + ", val : " + matrix[i][j] + ", center : " + center);
				if (center) {
					int a1 = navigateTop(matrix, i, j, cache);
					int a2 = navigateBottom(matrix, i, j, cache);
					int a3 = navigateRight(matrix, i, j, cache);
					int a4 = navigateLeft(matrix, i, j, cache);
					int currMax = Math.min(a1, Math.min(a2, Math.min(a3, a4))) + 1;
					System.out.println("currMax : " + currMax);
					cache.put(new MatrisPos(i, j), new NavigationLength(a1, a2, a3, a4));

					maxLength = Math.max(maxLength, currMax);

				}
			}
		}

		return maxLength;
	}

	private boolean areWeAtCenter(int[][] matrix, int i, int j) {
		if (matrix[i][j] != 1) {
			return false;
		}
		// corner condition
		if (i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[i].length - 1) {
			return false;
		}

		if (matrix[i - 1][j] == 1 && matrix[i + 1][j] == 1 && matrix[i][j - 1] == 1 && matrix[i][j + 1] == 1) {
			return true;
		}
		return false;
	}

	// check Top
	int navigateTop(int[][] matrix, int i, int j, Map<MatrisPos, NavigationLength> cache) {
		NavigationLength navigationLength = cache.get(new MatrisPos(i - 1, j));

		if (navigationLength != null) {
			System.out.println("Cache Hit");
			return navigationLength.topLen + 1;
		}
		int res = 0;
		for (int i1 = i - 1; i1 >= 0; i1--) {
			if (matrix[i1][j] == 1) {
				res++;
			}
		}
		return res;
	}

	// check bottom
	int navigateBottom(int[][] matrix, int i, int j, Map<MatrisPos, NavigationLength> cache) {
		NavigationLength navigationLength = cache.get(new MatrisPos(i + 1, j));

		if (navigationLength != null) {
			return navigationLength.bottomLen + 1;
		}
		int res = 0;
		for (int i1 = i + 1; i1 < matrix.length; i1++) {
			if (matrix[i1][j] == 1) {
				res++;
			}
		}
		return res;
	}

	// check left
	int navigateLeft(int[][] matrix, int i, int j, Map<MatrisPos, NavigationLength> cache) {

		NavigationLength navigationLength = cache.get(new MatrisPos(i, j - 1));

		if (navigationLength != null) {
			System.out.println("Cache Hit");
			return navigationLength.leftLen + 1;
		}

		int res = 0;
		for (int j1 = j - 1; j1 >= 0; j1--) {
			if (matrix[i][j1] == 1) {
				res++;
			}
		}
		return res;
	}

	// check right
	int navigateRight(int[][] matrix, int i, int j, Map<MatrisPos, NavigationLength> cache) {
		NavigationLength navigationLength = cache.get(new MatrisPos(i, j + 1));

		if (navigationLength != null) {
			return navigationLength.righttLen + 1;
		}

		int res = 0;
		for (int j1 = j + 1; j1 < matrix[i].length; j1++) {
			if (matrix[i][j1] == 1) {
				res++;
			}
		}
		return res;
	}

}
