import java.util.ArrayList;

public class OrdreHistorik {
    private ArrayList<Pizza> ordreHistory = new ArrayList<>();


    public void addOrder (Pizza pizza) {
        ordreHistory.add(pizza);
    }


    public void showOrderHistory() {
        System.out.println("Ordrehistorik: ");
        for (Pizza p : ordreHistory) {
            System.out.println(p);
        }
    }

    public int calculateTotalEarnings() {
        int total = 0;
        for (Pizza p : ordreHistory) {
            total += p.getPrice();
        }
        return total;
    }


    public void showTotalSales() {
        System.out.println("Antal bestilte pizzaer: " + ordreHistory.size());
        System.out.println("Dagens indtjening: " + calculateTotalEarnings() + " kr.");
    }

}
