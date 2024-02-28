package Others;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillSplitter {

    public static void main(String[] args) {
        // Example usage
    	
		List<String> participants = new ArrayList<String>();
		participants.add("Raghu");
		participants.add("Siva");
		participants.add("Vignesh");

    	
        Map<String, Double> expenses = new HashMap<>();
    	expenses.put("Raghu", 35.0);
    	expenses.put("Siva", 50.0);
    	expenses.put("Senthil", 65.0);

        Map<String, Map<String, Double>> result = splitBills(expenses);

        System.out.println("Bills Split:");
        for (Map.Entry<String, Map<String, Double>> entry : result.entrySet()) {
            String payer = entry.getKey();
            Map<String, Double> debts = entry.getValue();
            
            for (Map.Entry<String, Double> debtEntry : debts.entrySet()) {
                String receiver = debtEntry.getKey();
                Double amount = debtEntry.getValue();
                
                System.out.println(payer + " owes " + amount + " to " + receiver);
            }
        }
    }

    public static Map<String, Map<String, Double>> splitBills(Map<String, Double> expenses) {
        Map<String, Double> balances = new HashMap<>();

        // Calculate individual balances
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            balances.put(entry.getKey(), entry.getValue());
        }

        // Calculate total expense
        double totalExpense = expenses.values().stream().mapToDouble(Double::doubleValue).sum();
        double share = totalExpense / balances.size();

        // Adjust balances
        for (String person : expenses.keySet()) {
            balances.put(person, balances.get(person) - share);
        }

        // Identify who owes whom
        Map<String, Map<String, Double>> result = new HashMap<>();
        for (Map.Entry<String, Double> entry : balances.entrySet()) {
            String payer = entry.getKey();
            double amount = entry.getValue();

            if (amount < 0) {
                Map<String, Double> debts = new HashMap<>();
                for (Map.Entry<String, Double> otherEntry : balances.entrySet()) {
                    String receiver = otherEntry.getKey();
                    double receiverBalance = otherEntry.getValue();

                    if (receiverBalance > 0) {
                        double settledAmount = Math.min(Math.abs(amount), receiverBalance);
                        debts.put(receiver, settledAmount);
                        amount += settledAmount;
                        receiverBalance -= settledAmount;

                        balances.put(payer, amount);
                        balances.put(receiver, receiverBalance);
                    }

                    if (amount == 0) {
                        break;
                    }
                }

                result.put(payer, debts);
            }
        }

        return result;
    }
}
