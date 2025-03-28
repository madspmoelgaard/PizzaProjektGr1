import java.util.ArrayList;
import java.util.List;

public class OrderSystem {
    private int orderId;
    private String customerName;
    private List<String> pizzas;

    ArrayList<OrderSystem> orderSystem = new ArrayList<>();

    public void addToOrderSystem(OrderSystem order) {
        orderSystem.add(order);
    }

    public OrderSystem (int orderId, String customerName, List<String> pizzas) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.pizzas = pizzas;
    }

    public int getOrderId() {
        return orderId;
    }


    public void deleteOrder(int orderId) {
        for(OrderSystem o : orderSystem)
            if (o.getOrderId() == orderId) {
                orderSystem.remove(orderId - 1);
                System.out.println("Kunde ID " + orderId + " er blevet slettet.");
                return;
            }

        System.out.println("Kunde ID" + orderId + " ikke fundet.");
    }

    public void listOrders() {
        if (orderSystem.isEmpty()) {
            System.out.println("Ingen ordre tilgængelige.");
        } else {
            System.out.println("Nuværende ordre :");
            for (OrderSystem order : orderSystem) {
                System.out.println(order);
            }
        }
    }

    @Override
    public String toString() {
        return "Kunde ID: " + orderId + ", Kunde: " + customerName + ", Pizzaer: " + pizzas;
    }

}
