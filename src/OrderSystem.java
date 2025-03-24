import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderSystem {

    private int orderId;
    private String customerName;
    private List<String> pizzas;
    private List<OrderSystem> orders;

    public OrderSystem() {
        this.orders = new ArrayList<>();
    }

    public void Order(int orderId, String customerName, List<String> pizzas) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.pizzas = pizzas;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Kunde ID: " + orderId + ", Kunde: " + customerName + ", Pizzaer: " + pizzas;
    }

    public void addOrder(OrderSystem order) {
        orders.add(order);
        System.out.println("Ordre tilføjet: " + order);
    }

    public void deleteOrder(int orderId) {
        Iterator<OrderSystem> iterator = orders.iterator();
        while (iterator.hasNext()) {
            OrderSystem order  = iterator.next();
            if (getOrderId() == orderId) {
                iterator.remove();
                System.out.println("Kunde ID " + order + orderId + " er blevet slettet.");
                return;
            }
        }
        System.out.println("Kunde ID" + orderId + " ikke fundet.");
    }

    public void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("Ingen ordre tilgængelige.");
        } else {
            System.out.println("Nuværende ordre :");
            for (OrderSystem order : orders) {
                System.out.println(order);
            }
        }
    }
}
