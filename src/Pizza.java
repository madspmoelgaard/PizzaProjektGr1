public class Pizza {
    private int number;
    private String name;
    private String ingredients;
    private int price;


    //Constructor
    public Pizza(int number, String name, String ingredients, int price) {
        this.number = number;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return number + ": " + name + ingredients + ", " + price + ",-";
    }
}
