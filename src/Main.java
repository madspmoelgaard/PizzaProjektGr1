import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Menu menu = new Menu();
        initializeMenu(menu);

        OrdreHistorik ordreHistorik = new OrdreHistorik();
        BestillingsKlasse orderList = new BestillingsKlasse();

        menu.showMenu();
        System.out.println("\nHvilken pizza kunne du tænke dig at bestille?");

        boolean newOrder = true;
        while (newOrder) {
            int order = userInput.nextInt();
            if (order == 0) {
                newOrder = false;
                break;
            }
            Pizza foundPizza = menu.searchPizzaByNumber(order);
            if (foundPizza != null) {
                orderList.addOrder(foundPizza);
                ordreHistorik.addOrder(foundPizza);
                System.out.println("Du har valgt en: " + foundPizza.getName());
            } else {
                System.out.println("Desværre, den findes ikke ... ");
            }
            System.out.println("Ellers andet? '0' = Nej Tak - Ellers vælg ny pizza ");
        }

        System.out.println("Din bestilling:");
        orderList.showOrder();

        ordreHistorik.showOrderHistory();
        ordreHistorik.showTotalSales();

        Pizza pizza = menu.searchPizzaByNumber(1);
        if (pizza != null) {
            pizza.setPrice(70);
            System.out.println("Ny pris for " + pizza.getName() + " er " + pizza.getPrice() + " kr.");
        }

        List<String> pizzas1 = List.of("BBQ Kylling", "Milano");
        List<String> pizzas2 = List.of("Hawaii", "Vesuvio");

        OrderSystem orderSystem = new OrderSystem(2, "Anna", pizzas2);
        orderSystem.addToOrderSystem(new OrderSystem(1, "Lars", pizzas1));
        orderSystem.addToOrderSystem(new OrderSystem(2, "Anna", pizzas2));

        orderSystem.listOrders();
        System.out.println();
        orderSystem.deleteOrder(1);
        System.out.println();
        orderSystem.listOrders();

        PizzaOrdre.PizzaKo pizzaKo = new PizzaOrdre.PizzaKo();
        PizzaOrdre.OrdreManager ordreManager = new PizzaOrdre.OrdreManager(pizzaKo);
        PizzaOrdre.OrdreInput ordreInput = new PizzaOrdre.OrdreInput(ordreManager);
        ordreInput.tagInput();

        System.out.println();
    }

    private static void initializeMenu(Menu menu) {
        menu.addPizza(new Pizza(1, "Vesuvio", "tomatsauce, ost, skinke og oregano", 57));
        menu.addPizza(new Pizza(2, "Amerikaner", "tomatsauce, ost, oksefars og oregano", 53));
        menu.addPizza(new Pizza(3, "Cacciatore", "tomatsauce, ost, pepperoni og oregano", 57));
        menu.addPizza(new Pizza(4, "Carbona", "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63));
        menu.addPizza(new Pizza(5, "Dennis", "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65));
        menu.addPizza(new Pizza(6, "Bertil", "tomatsauce, ost, bacon og oregano", 57));
        menu.addPizza(new Pizza(7, "Silvia", "tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano", 61));
        menu.addPizza(new Pizza(8, "Victoria", "tomatsauce, ost, skinke, ananas, champignon, løg og oregano", 61));
        menu.addPizza(new Pizza(9, "Toronfo", "tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61));
        menu.addPizza(new Pizza(10, "Capricciosa", "tomatsauce, ost, skinke, champignon og oregano", 61));
        menu.addPizza(new Pizza(11, "Hawaii", "tomatsauce, ost, skinke, ananas og oregano", 61));
        menu.addPizza(new Pizza(12, "Le Blissola", "tomatsauce, ost, skinke, rejer og oregano", 61));
        menu.addPizza(new Pizza(13, "Venezia", "tomatsauce, ost, skinke, bacon og oregano", 61));
        menu.addPizza(new Pizza(14, "Mafia", "tomatsauce, ost, pepperoni, bacon, løg og oregano", 63));
        menu.addPizza(new Pizza(15, "Diavola", "tomatsauce, ost, pepperoni, chili og oregano", 57));
        menu.addPizza(new Pizza(16, "Formaggi", "tomatsauce, mozzarella, gorgonzola, parmesan og oregano", 65));
        menu.addPizza(new Pizza(17, "Romana", "tomatsauce, ost, skinke, ansjoser og oregano", 61));
        menu.addPizza(new Pizza(18, "Quattro Stagioni", "tomatsauce, ost, skinke, champignon, artiskok og oliven", 65));
        menu.addPizza(new Pizza(19, "Marinara", "tomatsauce, hvidløg, oregano og basilikum", 53));
        menu.addPizza(new Pizza(20, "Bolognese", "tomatsauce, ost, kødsauce og oregano", 63));
        menu.addPizza(new Pizza(21, "Napoli", "tomatsauce, ost, ansjoser, kapers og oregano", 61));
        menu.addPizza(new Pizza(22, "Vesuvio", "tomatsauce, ost, bacon, rucola og parmesan", 65));
        menu.addPizza(new Pizza(23, "Milano", "tomatsauce, ost, kylling, pesto og oregano", 65));
        menu.addPizza(new Pizza(24, "Gorgonzola Speciale", "tomatsauce, ost, gorgonzola, valnødder og honning", 67));
        menu.addPizza(new Pizza(25, "Calzone", "indbagt pizza med tomatsauce, ost, skinke og champignon", 62));
        menu.addPizza(new Pizza(26, "Parma", "tomatsauce, ost, parmaskinke, rucola og parmesan", 69));
        menu.addPizza(new Pizza(27, "Siciliana", "tomatsauce, ost, tun, løg, oliven og oregano", 61));
        menu.addPizza(new Pizza(28, "Rustica", "tomatsauce, ost, kartofler, rosmarin og bacon", 65));
        menu.addPizza(new Pizza(29, "Vegetariana", "tomatsauce, ost, peberfrugt, aubergine, squash, løg og oregano", 61));
        menu.addPizza(new Pizza(30, "BBQ Kylling", "BBQ sauce, ost, kylling, bacon og rød peber", 67));
    }
}
