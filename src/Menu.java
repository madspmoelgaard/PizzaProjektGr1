import java.util.ArrayList;

public class Menu {
    // MINDER OM "FOREST"-KLASSEN I POKEMONJAGT og pokemon-klassen
    // Array med pizzaer

    private ArrayList<Pizza> PizzaMenu = new ArrayList<>();
    public void addPizza(Pizza pizza) {
        PizzaMenu.add(pizza);
    }

    public void showMenu() {
        System.out.println("Pizza Menu:");
        for (Pizza p : PizzaMenu) {
            System.out.println(p);
        }
    }

    public Pizza searchPizzaByNumber(int number) {
        for (Pizza p : PizzaMenu) {
            if (p.getNumber() == number) {
                return p;
            }
        }
        return null;
    }

    public Pizza searchPizzaByName(String name) {
        for (Pizza pizza : PizzaMenu) {
            if (pizza.getName().equalsIgnoreCase(name)) {
                return pizza;
            }
        }
        return null;
    }
}

        // Vis menu

        // Mulighed for at ændre priser efter statistik
        // Pizza Constructor med getter til bestilling og setter til pris
        //

