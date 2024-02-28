package Others;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*https://www.youtube.com/watch?v=rw4s4M3hFfs&ab_channel=Cl%C3%A9mentMihailescu*/
public class BestHouseForRent {

	public static void main(String[] args) {
		BestHouseForRent bestHouseForRent = new BestHouseForRent();
		Block[] blocks = new Block[5];
		Map<String, Boolean> places1 = new LinkedHashMap<>();
		places1.put("G", false);
		places1.put("S", true);
		places1.put("ST", false);
		blocks[0] = bestHouseForRent.new Block(places1);
		Map<String, Boolean> places2 = new LinkedHashMap<>();
		places2.put("G", true);
		places2.put("S", false);
		places2.put("ST", false);
		blocks[1] = bestHouseForRent.new Block(places2);
		Map<String, Boolean> places3 = new LinkedHashMap<>();
		places3.put("G", true);
		places3.put("S", true);
		places3.put("ST", false);
		blocks[2] = bestHouseForRent.new Block(places3);
		Map<String, Boolean> places4 = new LinkedHashMap<>();
		places4.put("G", false);
		places4.put("S", true);
		places4.put("ST", false);
		blocks[3] = bestHouseForRent.new Block(places4);
		Map<String, Boolean> places5 = new LinkedHashMap<>();
		places5.put("G", false);
		places5.put("S", true);
		places5.put("ST", true);
		blocks[4] = bestHouseForRent.new Block(places5);

		bestHouseForRent.setValue1(blocks, 0);

		for (Block block : blocks) {
			for (Entry<String, Integer> entry : block.scores.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			System.out.println("******");
		}
		bestHouseForRent.setValue2(blocks, 1);
		System.out.println("******");
		System.out.println("******");
		System.out.println("******");
		System.out.println("******");

		for (Block block : blocks) {
			for (Entry<String, Integer> entry : block.scores.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			System.out.println("******");
		}
	}

	class Block {
		Map<String, Boolean> places = new LinkedHashMap<>();
		Map<String, Integer> scores = new LinkedHashMap<>();

		public Block(Map<String, Boolean> places) {
			this.places = places;
		}
	}

	void setValue1(Block[] blocks, int pos) {
		if (pos >= blocks.length) {
			return;
		}
		setValue1(blocks, pos + 1);
		for (Entry<String, Boolean> entry : blocks[pos].places.entrySet()) {
			blocks[pos].scores.put(entry.getKey(), Integer.MAX_VALUE);
			if (entry.getValue()) {
				blocks[pos].scores.put(entry.getKey(), 0);
			} else {
				if (pos < blocks.length - 1) {
					if (blocks[pos + 1].scores.get(entry.getKey()) < blocks[pos].scores.get(entry.getKey())) {
						blocks[pos].scores.put(entry.getKey(), blocks[pos + 1].scores.get(entry.getKey()) + 1);
					}
				}
			}
		}
	}

	void setValue2(Block[] blocks, int pos) {
		if (pos >= blocks.length) {
			return;
		}
		for (Entry<String, Boolean> entry : blocks[pos].places.entrySet()) {
			if (entry.getValue()) {
				blocks[pos].scores.put(entry.getKey(), 0);
			} else {
				if (blocks[pos - 1].scores.get(entry.getKey()) < blocks[pos].scores.get(entry.getKey())) {
					blocks[pos].scores.put(entry.getKey(), blocks[pos - 1].scores.get(entry.getKey()) + 1);
				}
			}
		}
		setValue2(blocks, pos + 1);
	}

}
