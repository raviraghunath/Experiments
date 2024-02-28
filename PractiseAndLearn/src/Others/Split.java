package Others;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

class Transaction {

	String fromUserId;

	String toUserId;

	float amount;

	public Transaction(String fromUserId, String toUserId, float amount) {
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		this.amount = amount;
	}

}

public class Split {

	private static final int DECIMAL_PRECISION = 3;

	public static void main(String[] args) {

		Split split = new Split();
//		split.useCase1();
//		System.out.println("******************************");
//		split.useCase2();
//		System.out.println("******************************");
//		split.useCase3();
//		System.out.println("******************************");
//		split.useCase4();
		System.out.println("******************************");
		split.useCase5();
//		System.out.println("******************************");
//		split.useCase6();

	}

	private List<Transaction> splitWise(Map<String, Float> givers, List<String> participants) {
		float totalAmount = getTotalAmount(givers);
		Map<String, Float> shares = getShares(participants, totalAmount);
		for (String userId : participants) {
			if (givers.containsKey(userId)) {
				float givenAmt = givers.get(userId);
				if (givenAmt < shares.get(userId)) {
					shares.put(userId, shares.get(userId) - givenAmt);
					givenAmt = 0;
				} else {
					givenAmt -= shares.get(userId);
					shares.put(userId, 0f);
				}
				givers.put(userId, givenAmt);
			}
		}

		List<Entry<String, Float>> giversAmt = new ArrayList<Entry<String, Float>>(givers.entrySet());
		giversAmt.removeIf(new Predicate<Entry<String, Float>>() {

			@Override
			public boolean test(Entry<String, Float> t) {
				return true ? t.getValue() == 0.0f : false;
			}
		});
//		if (giversAmt.size() > 1) {
//			Collections.sort(giversAmt, new Comparator<Entry<String, Float>>() {
//
//				@Override
//				public int compare(Entry<String, Float> o1, Entry<String, Float> o2) {
//					return (int) (o2.getValue() - o1.getValue());
//				}
//			});
//		}

		List<Entry<String, Float>> sharesAmt = new ArrayList<Entry<String, Float>>(shares.entrySet());
		sharesAmt.removeIf(new Predicate<Entry<String, Float>>() {

			@Override
			public boolean test(Entry<String, Float> t) {
				return true ? t.getValue() == 0.0f : false;
			}
		});
//		Collections.sort(sharesAmt, new Comparator<Entry<String, Float>>() {
//
//			@Override
//			public int compare(Entry<String, Float> o1, Entry<String, Float> o2) {
//				return (int) (o1.getValue() - o2.getValue());
//			}
//		});

		int giverCounter = 0;
		int shareCounter = 0;
		List<Transaction> transactions = new ArrayList<Transaction>();
		while (giverCounter < giversAmt.size() && shareCounter < sharesAmt.size()) {
			Entry<String, Float> giverEntry = giversAmt.get(giverCounter);
			Entry<String, Float> shareEntry = sharesAmt.get(shareCounter);

			if (giverEntry.getValue().equals(shareEntry.getValue())) {
				transactions.add(new Transaction(shareEntry.getKey(), giverEntry.getKey(), shareEntry.getValue()));
				shareEntry.setValue(0f);
				giverEntry.setValue(0f);
				shareCounter++;
				giverCounter++;
			} else if (giverEntry.getValue() > shareEntry.getValue()) {
				transactions.add(new Transaction(shareEntry.getKey(), giverEntry.getKey(), shareEntry.getValue()));
				float f = giverEntry.getValue() - shareEntry.getValue();
				BigDecimal bd = new BigDecimal(f).setScale(DECIMAL_PRECISION, RoundingMode.HALF_UP);
				giverEntry.setValue(bd.floatValue());
				shareEntry.setValue(0f);
				shareCounter++;
			} else {
				transactions.add(new Transaction(shareEntry.getKey(), giverEntry.getKey(), giverEntry.getValue()));
				float f = shareEntry.getValue() - giverEntry.getValue();
				BigDecimal bd = new BigDecimal(f).setScale(DECIMAL_PRECISION, RoundingMode.HALF_UP);
				shareEntry.setValue(bd.floatValue());
				giverEntry.setValue(0f);
				giverCounter++;
			}
		}
		return transactions;
	}

	private float getTotalAmount(Map<String, Float> givers) {
		float amount = 0.0f;
		for (Entry<String, Float> entry : givers.entrySet()) {
			amount += entry.getValue();
		}
		return amount;
	}

	private Map<String, Float> getShares(List<String> participants, float totalAmount) {
		Map<String, Float> shares = new HashMap<String, Float>();

		for (String userId : participants) {
			float f = totalAmount / (float) participants.size();
			BigDecimal bd = new BigDecimal(f).setScale(DECIMAL_PRECISION, RoundingMode.HALF_UP);
			shares.put(userId, bd.floatValue());
		}
		return shares;
	}

	private void useCase1() {
		Map<String, Float> givers = new HashMap<String, Float>();
		givers.put("Raghu", 35f);
		givers.put("Siva", 50f);
		givers.put("Senthil", 65f);
		List<String> participants = new ArrayList<String>();
		participants.add("Raghu");
		participants.add("Siva");
		participants.add("Vignesh");
		List<Transaction> transactions = splitWise(givers, participants);

		for (Transaction transaction : transactions) {
			System.out.println(
					transaction.fromUserId + " ----- " + transaction.amount + " ------> " + transaction.toUserId);
		}
	}

	private void useCase2() {
		Map<String, Float> givers = new HashMap<String, Float>();
		givers.put("Siva", 150f);
		givers.put("Senthil", 65f);
		List<String> participants = new ArrayList<String>();
		participants.add("Raghu");
		participants.add("Siva");
		participants.add("Vignesh");
		List<Transaction> transactions = splitWise(givers, participants);

		for (Transaction transaction : transactions) {
			System.out.println(
					transaction.fromUserId + " ----- " + transaction.amount + " ------> " + transaction.toUserId);
		}
	}

	private void useCase3() {
		Map<String, Float> givers = new HashMap<String, Float>();
		givers.put("Siva", 150f);
		List<String> participants = new ArrayList<String>();
		participants.add("Raghu");
		participants.add("Siva");
		participants.add("Vignesh");
		List<Transaction> transactions = splitWise(givers, participants);

		for (Transaction transaction : transactions) {
			System.out.println(
					transaction.fromUserId + " ----- " + transaction.amount + " ------> " + transaction.toUserId);
		}
	}

	private void useCase4() {
		Map<String, Float> givers = new HashMap<String, Float>();
		givers.put("Senthil", 150f);
		List<String> participants = new ArrayList<String>();
		participants.add("Raghu");
		participants.add("Siva");
		participants.add("Vignesh");
		List<Transaction> transactions = splitWise(givers, participants);

		for (Transaction transaction : transactions) {
			System.out.println(
					transaction.fromUserId + " ----- " + transaction.amount + " ------> " + transaction.toUserId);
		}
	}

	private void useCase5() {
		Map<String, Float> givers = new HashMap<String, Float>();
		givers.put("a", 120f);
		givers.put("b", 20f);
		List<String> participants = new ArrayList<String>();
		participants.addAll(new ArrayList<String>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
				"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")));
		List<Transaction> transactions = splitWise(givers, participants);

		for (Transaction transaction : transactions) {
			System.out.println(
					transaction.fromUserId + " ----- " + transaction.amount + " ------> " + transaction.toUserId);
		}
	}

	private void useCase6() {
		Map<String, Float> givers = new HashMap<String, Float>();
		givers.put("Siva", 11f);
		givers.put("Raghu", 10f);
		givers.put("Vignesh", 9f);
		List<String> participants = new ArrayList<String>();
		participants.add("Raghu");
		participants.add("Siva");
		participants.add("Vignesh");
		List<Transaction> transactions = splitWise(givers, participants);

		for (Transaction transaction : transactions) {
			System.out.println(
					transaction.fromUserId + " ----- " + transaction.amount + " ------> " + transaction.toUserId);
		}
	}

}
