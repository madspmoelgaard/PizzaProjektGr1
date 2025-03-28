import java.util.ArrayList;

public class BestillingsKlasse {
    // Opret bestillinger igennem scanner fra main
    // Ventetid på bestillinger
    // Bestillings Kø
    // Afsltuning af ordre -> OdreHistorik


    ArrayList<Pizza> orderList = new ArrayList<>();

    public void addOrder(Pizza newOrder){
        orderList.add(newOrder);
    }

    public void showOrder(){
        int totalPrice = 0;
        for(Pizza p : orderList){
            System.out.println("— " + p.getName() + ", " + p.getPrice() + ",-");
            totalPrice += p.getPrice();
        }
        System.out.println();
        System.out.println("Samlet pris: " + totalPrice + ",-" );
        System.out.println("Tak for din bestilling!");
    }
}