package Others;

/*Yet to complete */

public class HowToPrintMaximumNumberUsingGiven4Keys {

	public static void main(String[] args) {
		method1(11);
	}

	private static void method1(int n) {
		int clipboard = -1;
		int numAfterClipboard = -1;
		int mx = 0, clipVal = 0, valWhenClip = 0;
		for (int i = 1; i <= n; i++) {
			if (numAfterClipboard != -1) {
				numAfterClipboard++;
			}
			if (clipboard == -1) {
				if (2 * (i - 3) >= i) {
					clipboard = (i - 3);
					clipVal = 2 * clipboard;
					numAfterClipboard = 0;
					mx = mx - 3;
				}
				
			} else {
				if (numAfterClipboard == 3) {
					clipboard = 2 * valWhenClip;
					clipboard = valWhenClip;
					numAfterClipboard = 0;
				} else {
					clipVal = mx + clipboard;
				}
			}

			mx = clipVal;
			if (numAfterClipboard == 0)
				valWhenClip = mx;
			System.out.println(i + "," + mx + "," + clipVal + "," + valWhenClip + "," + numAfterClipboard+","+clipboard);
		}
		System.out.println(mx);
	}

}
