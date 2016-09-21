package PokerGame;

import java.util.List;

import PokerGame.PokerGameproblem54_Helper.PWIN;

public class PokerGameproblem54 {

	public static void main(String[] args) {

		List<PokerGameHands> games = FileRead.getGames();
		int countPlayer1 = 0, countPlayer2 = 0;
		for (PokerGameHands g : games) {
			PokerGameproblem54_ObjContainer c1 = g.firstSet;
			PokerGameproblem54_ObjContainer c2 = g.secondSet;

			System.out.println("\n*******************");
			System.out.println(c1.list);
			System.out.println(c2.list);
			System.out.println(PWIN.getPoint(c1).pwin);
			System.out.println(PWIN.getPoint(c2).pwin);
			int n = c1.compareTo(c2);
			if (n > 0)
				countPlayer1++;
			else
				countPlayer2++;
			System.out.println(n > 0 ? "Player 1" : "Player 2");
		}
		System.out.println("No of Games : " + games.size());
		System.out.println("Player 1 : " + countPlayer1);
		System.out.println("Player 2 : " + countPlayer2);
	}

}
