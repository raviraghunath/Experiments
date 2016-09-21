package PokerGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRead {

	public static List<PokerGameHands> getGames() {
		List<PokerGameHands> games = new ArrayList<>();

		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(
					"C:\\Bluian\\Base - workspaces\\Experiments\\git\\PractiseAndLearn\\src\\Others\\Pk.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				String[] strs = sCurrentLine.split(" ");
				if (strs.length != 10)
					continue;
				PokerGameHands pg = new PokerGameHands();
				for (int i = 0; i < 10; i++) {
					String s = strs[i];
					char sym = s.charAt(s.length() - 1);
					char numC = s.charAt(0);
					int num = 0;
					if (numC == 'T')
						num = 10;
					else if (numC == 'J')
						num = 11;
					else if (numC == 'Q')
						num = 12;
					else if (numC == 'K')
						num = 13;
					else if (numC == 'A')
						num = 14;
					else
						num = Integer.parseInt(String.valueOf(numC));
					PokerGameproblem54_Obj obj = new PokerGameproblem54_Obj(num, sym);
					if (i >= 5)
						pg.secondSet.list.add(obj);
					else
						pg.firstSet.list.add(obj);
				}
				games.add(pg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return games;
	}

}
